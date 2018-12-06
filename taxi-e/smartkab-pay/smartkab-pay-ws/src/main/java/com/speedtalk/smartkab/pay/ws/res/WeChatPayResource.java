package com.speedtalk.smartkab.pay.ws.res;

import com.speedtalk.pay.wechat.Utils;
import com.speedtalk.pay.wechat.domin.UnifiedOrder;
import com.speedtalk.pay.wechat.req.UnifiedOrderRequest;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.order.objs.PayResult;
import com.speedtalk.smartkab.pay.ws.*;
import com.speedtalk.smartkab.pay.ws.db.TabPayrecords;
import com.speedtalk.smartkab.pay.ws.db.TabPhonecallbuss;
import com.speedtalk.smartkab.pay.ws.domain.WeChatH5PayInfo;
import com.speedtalk.smartkab.pay.ws.domain.WeChatPayInfo;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.SignatureException;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

@Path("wechatpay")
public class WeChatPayResource {
    private static final Logger LOG = Logger.getLogger(WeChatPayResource.class.getName());
    private static final String SUCCESS = "<xml><return_code><![CDATA[SUCCESS]]></return_code></xml>";
    private static final String WECHAT_PACKAGE = "Sign=WXPay";
    private BaseDao dao = new BaseDao();
    private UnifiedOrderRequest request = new UnifiedOrderRequest();
    @Context
    private HttpServletRequest req;

    public static void main(String[] args) {
        String body = "taxi pay--12345678910";

        UnifiedOrder order = new UnifiedOrder();
        order.setAppid("wx571538e0951f01ba");
        order.setBody(body);
        order.setMch_id("1372470002");
        order.setNonce_str(Utils.getRandomNum(11));
        order.setNotify_url("http://219.137.66.123:7777/taxipay/wechatpay/async");
        order.setOut_trade_no("12345678911");
        order.setSpbill_create_ip("127.0.0.1");
        try {
            order.setTotal_fee("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        order.setTrade_type(com.speedtalk.pay.wechat.Constants.JSAPI);
        //		order.setTrade_type("MWEB");
        order.setOpenid("ogkq8wTQndbR3h1ZgLxPXW8PJp1A");

        Map<String, String> map = new UnifiedOrderRequest().request(order, "01DDF329FB531BA800D96E1C6FACE09A");
        System.out.println(" prepare order msg: " + map.get("return_msg") + ",resp:" + map.toString());
    }

    @POST
    @Path("async")
    @Consumes(MediaType.TEXT_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String asyncNotify(String xmlStr) {
        LOG.info("====asyncNotify......" + req.getRemoteAddr() + "," + xmlStr);

        Map<String, String> reqMap = null;
        try {
            reqMap = Utils.parseXmlStr(xmlStr.replaceAll("\n", ""));
        } catch (Exception e1) {
            e1.printStackTrace();
            return "";
        }
        String tradeType = reqMap.get("trade_type");
        String key = LoadXmlConfig.getConfigHash().get("wechat_key");
        String sourceSign = reqMap.remove("sign");
        if (com.speedtalk.pay.wechat.Constants.NATIVE.equalsIgnoreCase(tradeType) || com.speedtalk.pay.wechat.Constants.JSAPI
                .equalsIgnoreCase(tradeType) || com.speedtalk.pay.wechat.Constants.MWEB.equalsIgnoreCase(tradeType))
            key = LoadXmlConfig.getConfigHash().get("wechat_native_key");
        String sign = Utils.getSign(reqMap, key);
        boolean isOk = false;
        try {
            isOk = sourceSign.equals(sign);
        } catch (Exception e) {
            LOG.info("Check WeChatPay async notify exception!");
            e.printStackTrace();
            return "";
        }
        if (isOk) {
            String mchId = LoadXmlConfig.getConfigHash().get("mch_id");
            if (reqMap.get("trade_type").equals(com.speedtalk.pay.wechat.Constants.APP))
                mchId = LoadXmlConfig.getConfigHash().get("partner_id");
            TabPhonecallbuss order = (TabPhonecallbuss) dao.get(TabPhonecallbuss.class, reqMap.get("out_trade_no"));
            try {
                if (reqMap.get("result_code").equals("SUCCESS")) { //支付成功
                    if (/*Float.parseFloat(reqMap.get("total_fee")) - order.getMoney() * 100f == 0 &&*/
                            reqMap.get("mch_id").equals(mchId)) {
                        PayResult payResult=null;
                        try {
                            String driverSQL = "select account,name from tab_driver where msid = '" + order.getMsid() + "'";
                            List<Object[]> list = dao.get(driverSQL);
                            payResult = new PayResult((String) list.get(0)[0], (String) list.get(0)[1], order.getBillid(), OrderMessConstants.WECHAT_PAY, "success");
                            MqUtils.getInstance().getSender().sendMessage(payResult);
                            LOG.info(MqUtils.getInstance().getSenderInfo() + "--" + payResult.toString());
                        } catch (JMSException jmse) {
                            try {
                                MqUtils.getInstance().getNewSender().sendMessage(payResult);
                                LOG.info(MqUtils.getInstance().getSenderInfo() + "--" + payResult.toString());
                            } catch (JMSException jmsee) {
                                System.out.println("Send payment result occur exception");
                                jmsee.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        TabPayrecords payrecords = (TabPayrecords) dao.get(TabPayrecords.class, order.getBillid());
                        try {
                            payrecords.setPaytype((short) OrderMessConstants.WECHAT_PAY);
                            payrecords.setPaytime(new Timestamp(System.currentTimeMillis()));
                            payrecords.setTradeno(reqMap.get("transaction_id"));
                            dao.update(payrecords);
                        } catch (Exception e) {
                            ExcepPrinter.print(e);
                        }
                        LOG.info("WeChatPay async notify success!" + reqMap.get("out_trade_no"));
                        return SUCCESS;
                    } else {
                        LOG.info("Check WeChatPay async param error! total_fee:" + reqMap.get("total_fee") + ",order money:" + order
                                .getMoney() + ",mch_id:" + reqMap.get("mch_id") + ",config_mch_id:" + LoadXmlConfig.getConfigHash()
                                .get("mch_id"));
                        return "";
                    }
                } else {
                    LOG.info("WeChatPay async notify without Payment: " + reqMap.get("result_code"));
                    return SUCCESS;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LOG.info("Check WeChatPay async notify error! " + isOk);
        return "";
    }

    @GET
    @Path("getpayinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public WeChatPayInfo getPayInfo(@QueryParam("token") String token, @QueryParam("ordernum") String orderNum) {
        WeChatPayInfo resp = new WeChatPayInfo(Constants.PARAM_ERR_CODE, Constants.PARAM_ERR_DESC);
        Jws<Claims> claims = null;
        try {
            claims = TokenUtil.checkJwtToken(token, KeyUtil.getInstance().getKey());
        } catch (ExpiredJwtException eje) {
            resp.setCode(Constants.TOKEN_EXPIRED_CODE);
            resp.setDesc(Constants.TOKEN_EXPIRED_DESC);
            LOG.info(token + " token expired!");
            return resp;
        } catch (SignatureException se) {
            resp.setCode(Constants.TOKEN_ERR_CODE);
            resp.setDesc(Constants.TOKEN_ERR_DESC);
            LOG.info(token + " token error!");
            return resp;
        }
        TabPhonecallbuss tbOrder = null;
        try {
            tbOrder = (TabPhonecallbuss) dao.get(TabPhonecallbuss.class, orderNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == tbOrder || (null == tbOrder.getMsid() || tbOrder.getMsid().trim().equals(""))) {
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " order error! " + orderNum);
            return resp;
        }
        String passenger = claims.getBody().getSubject();
        if (passenger.equalsIgnoreCase(tbOrder.getCallnumber())) {
            //			String driverSQL = "select kabnum,phone from tab_driver where msid = '"+tbOrder.getMsid()
            //					+"'";
            //			List<Object[]> list = dao.get(driverSQL);
            //			String body = "打车:"+list.get(0)[0]+"-电话:"+list.get(0)[1];
            String body = "taxi pay--" + tbOrder.getBillid();
            String nonceStr = Utils.getRandomNum(11);

            UnifiedOrder order = new UnifiedOrder();
            order.setAppid(LoadXmlConfig.getConfigHash().get("wechat_appid"));
            order.setBody(body);
            order.setMch_id(LoadXmlConfig.getConfigHash().get("partner_id"));
            order.setNonce_str(nonceStr);
            order.setNotify_url(LoadXmlConfig.getConfigHash().get("wechatpay_notify_url"));
            order.setOut_trade_no(tbOrder.getBillid());
            order.setSpbill_create_ip("127.0.0.1");
            try {
                order.setTotal_fee(String.valueOf((int) (tbOrder.getMoney() * 100)));
            } catch (Exception e) {
                resp.setCode(Constants.MONEY_EMPTY_CODE);
                resp.setDesc(Constants.MONEY_EMPTY_DESC);
                LOG.info(claims.getBody().getSubject() + " money is null! " + orderNum);
                return resp;
            }
            order.setTrade_type(com.speedtalk.pay.wechat.Constants.APP);

            Map<String, String> map = request.request(order, LoadXmlConfig.getConfigHash().get("wechat_key"));
            LOG.info(claims.getBody()
                    .getSubject() + " prepare order msg: " + map.get("return_msg") + ",resp:" + map.toString());
            if (null == map || null == map.get("prepay_id")) {
                resp.setCode(Constants.PREPARE_ORDER_ERR_CODE);
                resp.setDesc(Constants.PREPARE_ORDER_ERR_DESC);
                LOG.info(claims.getBody().getSubject() + " order error! " + orderNum);
                return resp;
            }
            Map<String, String> reqMap = new TreeMap<String, String>();
            reqMap.put("appid", LoadXmlConfig.getConfigHash().get("wechat_appid"));
            reqMap.put("partnerid", LoadXmlConfig.getConfigHash().get("partner_id"));
            reqMap.put("prepayid", map.get("prepay_id"));
            reqMap.put("package", WECHAT_PACKAGE);
            reqMap.put("noncestr", nonceStr);
            reqMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
            try {
                String sign = Utils.getSign(reqMap, LoadXmlConfig.getConfigHash().get("wechat_key"));
                resp.setCode(Constants.SUCCESS_CODE);
                resp.setDesc(Constants.SUCCESS_DESC);
                resp.setAppid(LoadXmlConfig.getConfigHash().get("wechat_appid"));
                resp.setPartnerid(LoadXmlConfig.getConfigHash().get("partner_id"));
                resp.setPrepayid(map.get("prepay_id"));
                resp.setPackagestr(WECHAT_PACKAGE);
                resp.setNoncestr(reqMap.get("noncestr"));
                resp.setTimestamp(reqMap.get("timestamp"));
                resp.setSign(sign);
                LOG.info(claims.getBody().getSubject() + " get pay info:" + resp.toString());
                return resp;
            } catch (Exception e) {
                LOG.info(claims.getBody().getSubject() + " get sign error!");
                return resp;
            }

        } else {
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " passenger error!");
            return resp;
        }
    }

    @GET
    @Path("getpayofcoupon")
    @Produces(MediaType.APPLICATION_JSON)
    public WeChatPayInfo getPayOfCoupon(@QueryParam("token") String token, @QueryParam("ordernum") String orderNum, @QueryParam("coupon") long coupon) {
        WeChatPayInfo resp = new WeChatPayInfo(Constants.PARAM_ERR_CODE, Constants.PARAM_ERR_DESC);
        Jws<Claims> claims = null;
        try {
            claims = TokenUtil.checkJwtToken(token, KeyUtil.getInstance().getKey());
        } catch (ExpiredJwtException eje) {
            resp.setCode(Constants.TOKEN_EXPIRED_CODE);
            resp.setDesc(Constants.TOKEN_EXPIRED_DESC);
            LOG.info(token + " token expired!");
            return resp;
        } catch (SignatureException se) {
            resp.setCode(Constants.TOKEN_ERR_CODE);
            resp.setDesc(Constants.TOKEN_ERR_DESC);
            LOG.info(token + " token error!");
            return resp;
        }
        TabPhonecallbuss tbOrder = null;
        try {
            tbOrder = (TabPhonecallbuss) dao.get(TabPhonecallbuss.class, orderNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == tbOrder || (null == tbOrder.getMsid() || tbOrder.getMsid().trim().equals(""))) {
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " order error! " + orderNum);
            return resp;
        }
        String passenger = claims.getBody().getSubject();

        String tempAccount = passenger.replaceAll("(?i)delete|(?i)select|(?i)update", "");
        String sql = "SELECT c.id,c.type,c.money,p.isreceive,p.endtime,c.maxDeduction,c.serviceConditions " + "FROM tab_discount_coupon c,tab_discount_passenger p " + "where c.id = p.discid and p.isuse = 0 and p.isreceive=1 " + "and p.opruser='" + tempAccount + "' and p.discid=" + coupon;
        List<Object[]> coupons = dao.get(sql);
        if (null == coupons || coupons.isEmpty()) {
            resp.setCode(Constants.COUPON_ERR);
            resp.setDesc(Constants.COUPON_ERR_DESC);
            LOG.info(passenger + " coupon error!" + coupon);
            return resp;
        }
        float condition = Float.valueOf(coupons.get(0)[6].toString().trim());
        float money = tbOrder.getMoney();
        if (money < condition) {
            resp.setCode(Constants.USE_COUPON_ERR);
            resp.setDesc(Constants.USE_COUPON_ERR_DESC);
            LOG.info(passenger + " use coupon error!" + money + "," + condition);
            return resp;
        }
        String type = String.valueOf(coupons.get(0)[1]);    //优惠券类型1.代金券、2.打折券
        float value = Float.valueOf(coupons.get(0)[2].toString().trim());
        float deduction = Float.valueOf(coupons.get(0)[5].toString().trim());
        if ("1".equals(type)) {
            if (value >= money)
                money = 0f;
            else
                money = Math.round(money - value);
        } else {
            if (money * (1 - value) > deduction)
                money = money - deduction;
            else
                money = Math.round(money * value);
        }

        if (money == 0f) {
            resp.setCode(Constants.NOT_PAY_CODE);
            resp.setDesc(Constants.NOT_PAY_CODE);
            LOG.info(passenger + " 0 money! " + coupon);
            return resp;
        }

        if (passenger.equalsIgnoreCase(tbOrder.getCallnumber())) {
            //			String driverSQL = "select kabnum,phone from tab_driver where msid = '"+tbOrder.getMsid()
            //					+"'";
            //			List<Object[]> list = dao.get(driverSQL);
            //			String body = "打车:"+list.get(0)[0]+"-电话:"+list.get(0)[1];
            String body = "taxi pay--" + tbOrder.getBillid();
            String nonceStr = Utils.getRandomNum(11);

            UnifiedOrder order = new UnifiedOrder();
            order.setAppid(LoadXmlConfig.getConfigHash().get("wechat_appid"));
            order.setBody(body);
            order.setMch_id(LoadXmlConfig.getConfigHash().get("partner_id"));
            order.setNonce_str(nonceStr);
            order.setNotify_url(LoadXmlConfig.getConfigHash().get("wechatpay_notify_url"));
            order.setOut_trade_no(tbOrder.getBillid());
            order.setSpbill_create_ip("127.0.0.1");
            try {
                order.setTotal_fee(String.valueOf((int) (money * 100)));
            } catch (Exception e) {
                resp.setCode(Constants.MONEY_EMPTY_CODE);
                resp.setDesc(Constants.MONEY_EMPTY_DESC);
                LOG.info(claims.getBody().getSubject() + " money is null! " + orderNum);
                return resp;
            }
            order.setTrade_type(com.speedtalk.pay.wechat.Constants.APP);
            Map<String, String> map = request.request(order, LoadXmlConfig.getConfigHash().get("wechat_key"));
            LOG.info(claims.getBody()
                    .getSubject() + " prepare order msg: " + map.get("return_msg") + ",resp:" + map.toString());
            if (null == map || null == map.get("prepay_id")) {
                resp.setCode(Constants.PREPARE_ORDER_ERR_CODE);
                resp.setDesc(Constants.PREPARE_ORDER_ERR_DESC);
                LOG.info(claims.getBody().getSubject() + " order error! " + orderNum);
                return resp;
            }
            Map<String, String> reqMap = new TreeMap<String, String>();
            reqMap.put("appid", LoadXmlConfig.getConfigHash().get("wechat_appid"));
            reqMap.put("partnerid", LoadXmlConfig.getConfigHash().get("partner_id"));
            reqMap.put("prepayid", map.get("prepay_id"));
            reqMap.put("package", WECHAT_PACKAGE);
            reqMap.put("noncestr", nonceStr);
            reqMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
            try {
                String sign = Utils.getSign(reqMap, LoadXmlConfig.getConfigHash().get("wechat_key"));
                resp.setCode(Constants.SUCCESS_CODE);
                resp.setDesc(Constants.SUCCESS_DESC);
                resp.setAppid(LoadXmlConfig.getConfigHash().get("wechat_appid"));
                resp.setPartnerid(LoadXmlConfig.getConfigHash().get("partner_id"));
                resp.setPrepayid(map.get("prepay_id"));
                resp.setPackagestr(WECHAT_PACKAGE);
                resp.setNoncestr(reqMap.get("noncestr"));
                resp.setTimestamp(reqMap.get("timestamp"));
                resp.setSign(sign);
                LOG.info(claims.getBody().getSubject() + " get pay info:" + resp.toString());

                //				sql = "update tab_discount_passenger p set p.isuse = 1 where "
                //						   + "p.opruser='" + tempAccount + "' and p.discid=" + coupon;
                //				dao.executeSql(sql);

                return resp;
            } catch (Exception e) {
                LOG.info(claims.getBody().getSubject() + " get sign error!");
                return resp;
            }
        } else {
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " passenger error!");
            return resp;
        }
    }

    @GET
    @Path("getpayh5")
    @Produces(MediaType.APPLICATION_JSON)
    public WeChatH5PayInfo getPayInfoByH5(@QueryParam("token") String token, @QueryParam("ordernum") String orderNum, @QueryParam("openid") String openid, @QueryParam("type") String tradeType, @QueryParam("coupon") String coupon) {
        WeChatH5PayInfo resp = new WeChatH5PayInfo(Constants.PARAM_ERR_CODE, Constants.PARAM_ERR_DESC);
        Jws<Claims> claims = null;
        try {
            claims = TokenUtil.checkJwtToken(token, KeyUtil.getInstance().getKey());
        } catch (ExpiredJwtException eje) {
            resp.setCode(Constants.TOKEN_EXPIRED_CODE);
            resp.setDesc(Constants.TOKEN_EXPIRED_DESC);
            LOG.info(token + " token expired!");
            return resp;
        } catch (SignatureException se) {
            resp.setCode(Constants.TOKEN_ERR_CODE);
            resp.setDesc(Constants.TOKEN_ERR_DESC);
            LOG.info(token + " token error!");
            return resp;
        }
        TabPhonecallbuss tbOrder = null;
        try {
            tbOrder = (TabPhonecallbuss) dao.get(TabPhonecallbuss.class, orderNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == tbOrder || (null == tbOrder.getMsid() || tbOrder.getMsid().trim().equals(""))) {
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " order error! " + orderNum);
            return resp;
        }
        String passenger = claims.getBody().getSubject();
        float money = tbOrder.getMoney();

        if (coupon != null && !coupon.trim().equals("")) {
            String tempAccount = passenger.replaceAll("(?i)delete|(?i)select|(?i)update", "");
            String sql = "SELECT c.id,c.type,c.money,p.isreceive,p.endtime,c.maxDeduction,c.serviceConditions " + "FROM tab_discount_coupon c,tab_discount_passenger p " + "where c.id = p.discid and p.isuse = 0 and p.isreceive=1 " + "and p.opruser='" + tempAccount + "' and p.discid=" + coupon;
            List<Object[]> coupons = dao.get(sql);
            if (null == coupons || coupons.isEmpty()) {
                resp.setCode(Constants.COUPON_ERR);
                resp.setDesc(Constants.COUPON_ERR_DESC);
                LOG.info(passenger + " coupon error!" + coupon);
                return resp;
            }
            float condition = Float.valueOf(coupons.get(0)[6].toString().trim());
            if (money < condition) {
                resp.setCode(Constants.USE_COUPON_ERR);
                resp.setDesc(Constants.USE_COUPON_ERR_DESC);
                LOG.info(passenger + " use coupon error!" + money + "," + condition);
                return resp;
            }
            String type = String.valueOf(coupons.get(0)[1]);    //优惠券类型1.代金券、2.打折券
            float value = Float.valueOf(coupons.get(0)[2].toString().trim());
            float deduction = Float.valueOf(coupons.get(0)[5].toString().trim());
            if ("1".equals(type)) {
                if (value >= money)
                    money = 0f;
                else
                    money = Math.round(money - value);
            } else {
                if (money * (1 - value) > deduction)
                    money = money - deduction;
                else
                    money = Math.round(money * value);
            }

            if (money == 0f) {
                resp.setCode(Constants.NOT_PAY_CODE);
                resp.setDesc(Constants.NOT_PAY_CODE);
                LOG.info(passenger + " 0 money! " + coupon);
                return resp;
            }
        }

        if (passenger.equalsIgnoreCase(tbOrder.getCallnumber())) {
            String body = "taxi pay--" + tbOrder.getBillid();
            String nonceStr = Utils.getRandomNum(11);

            UnifiedOrder order = new UnifiedOrder();
            order.setAppid(LoadXmlConfig.getConfigHash().get("wechat_native_appid"));
            order.setBody(body);
            order.setMch_id(LoadXmlConfig.getConfigHash().get("mch_id"));
            order.setNonce_str(nonceStr);
            order.setNotify_url(LoadXmlConfig.getConfigHash().get("wechatpay_notify_url"));
            order.setOut_trade_no(tbOrder.getBillid());
            order.setSpbill_create_ip("127.0.0.1");
            try {
                order.setTotal_fee(String.valueOf((int) (money * 100)));
            } catch (Exception e) {
                resp.setCode(Constants.MONEY_EMPTY_CODE);
                resp.setDesc(Constants.MONEY_EMPTY_DESC);
                LOG.info(claims.getBody().getSubject() + " money is null! " + orderNum);
                return resp;
            }
            if (null == tradeType || tradeType.trim().equals("") || tradeType.trim()
                    .equals(com.speedtalk.pay.wechat.Constants.JSAPI))
                order.setTrade_type(com.speedtalk.pay.wechat.Constants.JSAPI);
            else
                order.setTrade_type(com.speedtalk.pay.wechat.Constants.MWEB);
            order.setOpenid(openid);

            Map<String, String> map = request.request(order, LoadXmlConfig.getConfigHash().get("wechat_native_key"));
            LOG.info(claims.getBody()
                    .getSubject() + " prepare order msg: " + map.get("return_msg") + ",resp:" + map.toString());
            if (null == map || null == map.get("prepay_id")) {
                resp.setCode(Constants.PREPARE_ORDER_ERR_CODE);
                resp.setDesc(Constants.PREPARE_ORDER_ERR_DESC);
                LOG.info(claims.getBody().getSubject() + " order error! " + orderNum);
                return resp;
            }
            Map<String, String> reqMap = new TreeMap<String, String>();
            reqMap.put("appId", LoadXmlConfig.getConfigHash().get("wechat_native_appid"));
            reqMap.put("timeStamp", String.valueOf(System.currentTimeMillis() / 1000));
            reqMap.put("nonceStr", nonceStr);
            reqMap.put("package", "prepay_id=" + map.get("prepay_id"));
            reqMap.put("signType", "MD5");
            try {
                String sign = Utils.getSign(reqMap, LoadXmlConfig.getConfigHash().get("wechat_native_key"));
                resp.setCode(Constants.SUCCESS_CODE);
                resp.setDesc(Constants.SUCCESS_DESC);
                resp.setAppid(reqMap.get("appId"));
                resp.setTimestamp(reqMap.get("timeStamp"));
                resp.setNoncestr(reqMap.get("nonceStr"));
                resp.setPackagestr(reqMap.get("package"));
                resp.setSigntype(reqMap.get("signType"));
                resp.setSign(sign);
                LOG.info(claims.getBody().getSubject() + " get h5pay info:" + resp.toString());
                return resp;
            } catch (Exception e) {
                LOG.info(claims.getBody().getSubject() + " get sign error!");
                return resp;
            }

        } else {
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " passenger error!");
            return resp;
        }
    }
}
