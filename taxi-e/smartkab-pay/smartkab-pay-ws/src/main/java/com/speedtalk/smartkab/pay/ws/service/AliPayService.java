package com.speedtalk.smartkab.pay.ws.service;

import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.smartkab.pay.ws.Base64;
import com.speedtalk.smartkab.pay.ws.Constants;
import com.speedtalk.smartkab.pay.ws.domain.PayResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.*;
import java.util.logging.Logger;

public class AliPayService {
    private final static Logger LOG = Logger.getLogger(AliPayService.class.getName());

    /**
     * 构造支付订单参数列表
     *
     * @param app_id       应用ID
     * @param total_amount 总金额
     * @param subject      订单标题
     * @param body         订单描述
     * @param out_trade_no 订单号
     * @param timestamp    下单时间
     * @param notify_url   回调URL
     * @return 支付订单参数列表
     */
    public static Map<String, String> buildOrderParamMap(String app_id, String total_amount, String subject, String body, String out_trade_no, String seller_id, String timestamp, String notify_url) {
        Map<String, String> keyValues = new HashMap<String, String>();
        keyValues.put("app_id", app_id);
        /*
         * timeout_express 该笔订单允许的最晚付款时间 product_code 销售产品码,商家和支付宝签约的产品码
         * total_amount 订单总金额,单位为元,精确到小数点后两位 subject 商品的标题/交易标题/订单标题/订单关键字 body
         * 对一笔交易的具体描述信息 out_trade_no 商户网站唯一订单号 seller_id
         * 收款支付宝用户ID。若为空,则是商户签约账号ID
         */
        if (null == seller_id || seller_id.trim().equals("")) {
            keyValues.put("biz_content", "{\"timeout_express\":\"30m\",\"product_code\":\"QUICK_MSECURITY_PAY\",\"total_amount\":\"" + total_amount + "\",\"subject\":\"" + subject + "\",\"body\":\"" + body + "\",\"out_trade_no\":\"" + out_trade_no + "\"}");
        } else {
            keyValues.put("biz_content", "{\"timeout_express\":\"30m\",\"product_code\":\"QUICK_MSECURITY_PAY\",\"total_amount\":\"" + total_amount + "\",\"subject\":\"" + subject + "\",\"body\":\"" + body + "\",\"out_trade_no\":\"" + out_trade_no + "\",\"seller_id\":\"" + seller_id + "\"}");
        }
        keyValues.put("charset", "utf-8"); // 请求使用的编码格式
        keyValues.put("method", "alipay.trade.app.pay"); // 接口名称
        keyValues.put("sign_type", "RSA"); // 商户生成签名字符串所使用的签名算法类型
        keyValues.put("timestamp", timestamp); // 发送请求的时间
        keyValues.put("version", "1.0"); // 调用的接口版本,固定为: 1.0
        if (notify_url != null && !notify_url.trim().equals("")) {
            keyValues.put("notify_url", notify_url); // 支付宝服务器主动通知商户服务器里指定的页面http/https路径
        }
        return keyValues;
    }

    /**
     * 对支付参数信息进行签名
     *
     * @param map 待签名授权信息
     * @return
     */
    public static String getSign(Map<String, String> map, String rsaKey) {
        List<String> keys = new ArrayList<String>(map.keySet());
        // key排序
        Collections.sort(keys);
        StringBuilder authInfo = new StringBuilder();
        for (int i = 0; i < keys.size() - 1; i++) {
            String key = keys.get(i);
            String value = map.get(key);
            authInfo.append(buildKeyValue(key, value, false));
            authInfo.append("&");
        }
        String tailKey = keys.get(keys.size() - 1);
        String tailValue = map.get(tailKey);
        authInfo.append(buildKeyValue(tailKey, tailValue, false));
        String oriSign = sign(authInfo.toString(), rsaKey);
        String encodedSign = "";
        try {
            encodedSign = URLEncoder.encode(oriSign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "sign=" + encodedSign;
    }

    /**
     * 构造支付订单参数信息
     *
     * @param map 支付订单参数
     * @return
     */
    public static String buildOrderParam(Map<String, String> map) {
        List<String> keys = new ArrayList<String>(map.keySet());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.size() - 1; i++) {
            String key = keys.get(i);
            String value = map.get(key);
            sb.append(buildKeyValue(key, value, true)).append("&");
        }
        String tailKey = keys.get(keys.size() - 1);
        String tailValue = map.get(tailKey);
        sb.append(buildKeyValue(tailKey, tailValue, true));
        return sb.toString();
    }

    /**
     * 拼接键值对
     *
     * @param key
     * @param value
     * @param isEncode
     * @return
     */
    public static String buildKeyValue(String key, String value, boolean isEncode) {
        StringBuilder sb = new StringBuilder();
        sb.append(key).append("=");
        if (isEncode) {
            try {
                sb.append(URLEncoder.encode(value, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                sb.append(value);
            }
        } else {
            sb.append(value);
        }
        return sb.toString();
    }

    /**
     * 签名
     *
     * @param content    内容
     * @param privateKey 私钥
     * @return
     */
    public static String sign(String content, String privateKey) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
            java.security.Signature signature = java.security.Signature.getInstance("SHA1WithRSA");
            signature.initSign(priKey);
            signature.update(content.getBytes("UTF-8"));
            byte[] signed = signature.sign();
            return Base64.encode(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PayResponse getResult(String orderNum) {
        PayResponse resp = new PayResponse(Constants.NOT_PAY_CODE, "交易不存在", null, null);
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{\"out_trade_no\":\"" + orderNum + "\"}");
        try {
            AlipayTradeQueryResponse response = AliClient.getInstance().getAlipayClient().execute(request);
            String code = response.getCode();
            String tradeStatus = response.getTradeStatus();
            if ("10000".equals(code)) {
                if ("WAIT_BUYER_PAY".equals(tradeStatus))
                    resp.setDesc("支付宝等待用户支付");
                else if ("TRADE_CLOSED".equals(tradeStatus))
                    resp.setDesc("支付宝支付超时");
                else if ("TRADE_SUCCESS".equals(tradeStatus)) {
                    resp.setPaytype(String.valueOf(OrderMessConstants.ALIPAY_PAY));
                    //					String buyerPayAmount = response.getBuyerPayAmount();
                    String buyerPayAmount = response.getTotalAmount();
                    int amount = 0;
                    try {
                        amount = (int) (Float.parseFloat(buyerPayAmount) * 100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    resp.setAmount(String.valueOf(amount));
                    resp.setCode(Constants.SUCCESS_CODE);
                    resp.setDesc("支付宝支付成功");
                } else
                    LOG.info(orderNum + " trade status:" + tradeStatus);
            } else
                LOG.info(orderNum + " code " + code + " trade status:" + tradeStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}
