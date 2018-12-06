package com.speedtalk.smartkab.pay.ws.service;

import com.speedtalk.pay.wechat.Requester;
import com.speedtalk.pay.wechat.Utils;
import com.speedtalk.pay.wechat.domin.OrderQuery;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.smartkab.pay.ws.Constants;
import com.speedtalk.smartkab.pay.ws.domain.PayResponse;
import com.speedtalk.utils.LoadXmlConfig;

import java.util.Map;

public class WeChatPayService {
    public static PayResponse getResult(String orderNum) {
        PayResponse resp = new PayResponse(Constants.NOT_PAY_CODE, "订单未支付", null, null);

        Map<String, String> map;
        try {
            map = getAppResult(orderNum);
            if (map.get("result_code").equals("FAIL"))
                map = getNativeResult(orderNum);
            String tradeState = map.get("trade_state");
            if ("SUCCESS".equals(tradeState)) {
                resp.setPaytype(String.valueOf(OrderMessConstants.ALIPAY_PAY));
                resp.setAmount(map.get("total_fee"));
                resp.setCode(Constants.SUCCESS_CODE);
                resp.setDesc("微信支付成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    /**
     * 查询扫码支付结果
     *
     * @param orderNum
     * @return
     * @throws Exception
     */
    private static Map<String, String> getNativeResult(String orderNum) throws Exception {
        OrderQuery query = new OrderQuery(orderNum);
        query.setAppid(LoadXmlConfig.getConfigHash().get("wechat_native_appid"));
        query.setMch_id(LoadXmlConfig.getConfigHash().get("mch_id"));
        query.setNonce_str(Utils.getRandomNum(11));
        String respXml = Requester.request(query, "https://api.mch.weixin.qq.com/pay/orderquery", LoadXmlConfig.getConfigHash()
                .get("wechat_native_key"));
        System.out.println("WeChatPay result:" + respXml.toString());
        return Utils.parseXmlStr(respXml);
    }

    /**
     * 查询APP支付结果
     *
     * @param orderNum
     * @return
     * @throws Exception
     */
    private static Map<String, String> getAppResult(String orderNum) throws Exception {
        OrderQuery query = new OrderQuery(orderNum);
        query.setAppid(LoadXmlConfig.getConfigHash().get("wechat_appid"));
        query.setMch_id(LoadXmlConfig.getConfigHash().get("partner_id"));
        query.setNonce_str(Utils.getRandomNum(11));
        String respXml = Requester.request(query, "https://api.mch.weixin.qq.com/pay/orderquery", LoadXmlConfig.getConfigHash()
                .get("wechat_key"));
        System.out.println("WeChatPay result:" + respXml.toString());
        return Utils.parseXmlStr(respXml);
    }
}
