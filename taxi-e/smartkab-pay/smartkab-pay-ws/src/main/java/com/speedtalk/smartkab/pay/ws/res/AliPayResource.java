package com.speedtalk.smartkab.pay.ws.res;

import com.alipay.api.internal.util.AlipaySignature;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.order.objs.PayResult;
import com.speedtalk.smartkab.pay.ws.*;
import com.speedtalk.smartkab.pay.ws.db.TabPayrecords;
import com.speedtalk.smartkab.pay.ws.db.TabPhonecallbuss;
import com.speedtalk.smartkab.pay.ws.domain.Response;
import com.speedtalk.smartkab.pay.ws.service.AliPayService;
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
import javax.ws.rs.core.MultivaluedMap;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author chen
 */
@Path("alipay")
public class AliPayResource {
    private static final Logger LOG = Logger.getLogger(AliPayResource.class.getName());
    private BaseDao dao = new BaseDao();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Context
    private HttpServletRequest req;

    @POST
    @Path("async")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    //	public String asyncNotify(@BeanParam AliAsyncNotify notify)
    public String asyncNotify(MultivaluedMap<String, String> formParams) {
        LOG.info("====asyncNotify......" + req.getRemoteAddr());
        StringBuilder value = new StringBuilder();
        StringBuilder logBuf = new StringBuilder();
        Map<String, String> reqMap = new HashMap<String, String>();
        for (Map.Entry<String, List<String>> entry : formParams.entrySet()) {
            value.setLength(0);
            logBuf.append(entry.getKey()).append(":");
            for (String v : entry.getValue())
                value.append(v);
            logBuf.append(value.toString()).append(",");
            reqMap.put(entry.getKey(), value.toString());
        }

        boolean isOk = false;
        LOG.info("Receive Alipay async notify:" + logBuf.toString());
        try {
            reqMap.remove("sign_type");
            isOk = AlipaySignature.rsaCheckV2(reqMap, LoadXmlConfig.getConfigHash().get("ali_pkey"), "utf-8");
        } catch (Exception e) {
            LOG.info("Check Alipay async notify exception!");
            e.printStackTrace();
            return "";
        }
        if (isOk) {
            TabPhonecallbuss order = (TabPhonecallbuss) dao.get(TabPhonecallbuss.class, reqMap.get("out_trade_no"));
            try {
                if (reqMap.get("trade_status").equals("TRADE_SUCCESS") || reqMap.get("trade_status")
                        .equals("TRADE_FINISHED"))    //支付成功
                {
                    if (/*Float.parseFloat(reqMap.get("total_amount")) - order.getMoney() == 0 &&*/
                            reqMap.get("seller_id").equals(LoadXmlConfig.getConfigHash().get("seller_id"))) {
                        PayResult payResult = null;
                        try {
                            String driverSQL = "select account,name from tab_driver where msid = '" + order.getMsid() + "'";
                            List<Object[]> list = dao.get(driverSQL);
                            payResult = new PayResult((String) list.get(0)[0], (String) list.get(0)[1], order.getBillid(), OrderMessConstants.ALIPAY_PAY, "success");
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
                            payrecords.setPaytype((short) OrderMessConstants.ALIPAY_PAY);
                            payrecords.setPaytime(new Timestamp(System.currentTimeMillis()));
                            payrecords.setTradeno(reqMap.get("trade_no"));
                            dao.update(payrecords);
                        } catch (Exception e) {
                            ExcepPrinter.print(e);
                        }
                        LOG.info("Alipay async notify success!" + reqMap.get("out_trade_no"));
                        return "success";
                    } else {
                        LOG.info("Check Alipay async param error! total_amount:" + reqMap.get("total_amount") + ",order money:" + order
                                .getMoney() + ",seller_id:" + reqMap.get("seller_id") + ",sellerid:" + LoadXmlConfig.getConfigHash()
                                .get("seller_id"));
                        return "";
                    }
                } else {
                    LOG.info("Alipay async notify without Payment: " + reqMap.get("trade_status"));
                    return "success";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LOG.info("Check Alipay async notify error! " + isOk);
        return "";
    }

    @GET
    @Path("getpayinfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPayInfo(@QueryParam("token") String token, @QueryParam("ordernum") String orderNum) {
        Response resp = new Response(Constants.PARAM_ERR_CODE, Constants.PARAM_ERR_DESC);
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
        TabPhonecallbuss order = null;
        try {
            order = (TabPhonecallbuss) dao.get(TabPhonecallbuss.class, orderNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == order || (null == order.getMsid() || order.getMsid().trim().equals(""))) {
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " order error! " + orderNum);
            return resp;
        }
        String passenger = claims.getBody().getSubject();
        if (passenger.equalsIgnoreCase(order.getCallnumber())) {
            String driverSQL = "select kabnum,phone from tab_driver where msid = '" + order.getMsid() + "'";
            List<Object[]> list = dao.get(driverSQL);
            String body = "打车:" + list.get(0)[0] + "-电话:" + list.get(0)[1];
            Map<String, String> params = AliPayService.buildOrderParamMap(LoadXmlConfig.getConfigHash()
                    .get("app_id"), order.getMoney()
                    .toString(), "打车支付--" + body, body, orderNum, LoadXmlConfig.getConfigHash()
                    .get("seller_id"), sdf.format(System.currentTimeMillis()), LoadXmlConfig.getConfigHash()
                    .get("alipay_notify_url"));
            String orderParam = AliPayService.buildOrderParam(params);
            String sign = AliPayService.getSign(params, LoadXmlConfig.getConfigHash().get("ali_key"));
            String orderInfo = orderParam + "&" + sign;
            resp.setCode(Constants.SUCCESS_CODE);
            resp.setDesc(orderInfo);
            LOG.info(claims.getBody().getSubject() + " success! " + orderInfo);
        } else {
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " passenger error!");
            return resp;
        }
        return resp;
    }

    @GET
    @Path("getpayofcoupon")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPayOfCoupon(@QueryParam("token") String token, @QueryParam("ordernum") String orderNum, @QueryParam("coupon") long coupon) {
        Response resp = new Response(Constants.PARAM_ERR_CODE, Constants.PARAM_ERR_DESC);
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
        TabPhonecallbuss order = null;
        try {
            order = (TabPhonecallbuss) dao.get(TabPhonecallbuss.class, orderNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == order || (null == order.getMsid() || order.getMsid().trim().equals(""))) {
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
        float money = order.getMoney();
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

        if (passenger.equalsIgnoreCase(order.getCallnumber())) {
            String driverSQL = "select kabnum,phone from tab_driver where msid = '" + order.getMsid() + "'";
            List<Object[]> list = dao.get(driverSQL);
            String body = "打车:" + list.get(0)[0] + "-电话:" + list.get(0)[1];
            Map<String, String> params = AliPayService.buildOrderParamMap(LoadXmlConfig.getConfigHash()
                    .get("app_id"), String.valueOf(money), "打车支付--" + body, body, orderNum, LoadXmlConfig.getConfigHash()
                    .get("seller_id"), sdf.format(System.currentTimeMillis()), LoadXmlConfig.getConfigHash()
                    .get("alipay_notify_url"));
            String orderParam = AliPayService.buildOrderParam(params);
            String sign = AliPayService.getSign(params, LoadXmlConfig.getConfigHash().get("ali_key"));
            String orderInfo = orderParam + "&" + sign;
            resp.setCode(Constants.SUCCESS_CODE);
            resp.setDesc(orderInfo);
            LOG.info(passenger + " success! " + orderInfo);

            //			sql = "update tab_discount_passenger p set p.isuse = 1 where "
            //					   + "p.opruser='" + tempAccount + "' and p.discid=" + coupon;
            //			dao.executeSql(sql);
        } else {
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " passenger error!");
            return resp;
        }
        return resp;
    }

    @GET
    @Path("result")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkResult(@QueryParam("token") String token, @QueryParam("appid") String appid, @QueryParam("ordernum") String orderNum, @QueryParam("amount") String amount, @QueryParam("sellerid") String sellerid) {
        Response resp = new Response(Constants.PARAM_ERR_CODE, Constants.PARAM_ERR_DESC);
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
        TabPhonecallbuss order = null;
        try {
            order = (TabPhonecallbuss) dao.get(TabPhonecallbuss.class, orderNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == order || (null == order.getMsid() || order.getMsid().trim().equals(""))) {
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " order error! " + orderNum);
            return resp;
        }
        String passenger = claims.getBody().getSubject();
        if (passenger.equalsIgnoreCase(order.getCallnumber())) {
            if (appid.equals(LoadXmlConfig.getConfigHash()
                    .get("app_id")) && sellerid.equals(LoadXmlConfig.getConfigHash()
                    .get("seller_id")) && order.getMoney() - Float.parseFloat(amount) == 0) {
                resp.setCode(Constants.SUCCESS_CODE);
                resp.setDesc(Constants.SUCCESS_DESC);
                LOG.info(claims.getBody().getSubject() + " payment success!");
                return resp;
            } else
                LOG.info(claims.getBody().getSubject() + " check payment param error!");
        } else {
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " passenger error!");
            return resp;
        }
        return resp;
    }

    @GET
    @Path("money")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMoney(@QueryParam("token") String token, @QueryParam("ordernum") String orderNum) {
        Response resp = new Response(Constants.PARAM_ERR_CODE, Constants.PARAM_ERR_DESC);
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
        TabPhonecallbuss order = null;
        try {
            order = (TabPhonecallbuss) dao.get(TabPhonecallbuss.class, orderNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == order) {
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " order error! " + orderNum);
            return resp;
        }
        LOG.info(claims.getBody().getSubject() + " order info: " + order.toString());
        String passenger = claims.getBody().getSubject();
        if (passenger.equalsIgnoreCase(order.getCallnumber())) {
            if (null != order.getMsid() && null != order.getMoney()) {
                resp.setCode(Constants.SUCCESS_CODE);
                resp.setDesc(order.getMoney().toString());
                LOG.info(claims.getBody().getSubject() + " success!");
            } else {
                resp.setCode(Constants.MONEY_EMPTY_CODE);
                resp.setDesc(Constants.MONEY_EMPTY_DESC);
                LOG.info(claims.getBody().getSubject() + " money empty!");
            }

            return resp;
        } else {
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " passenger error!");
            return resp;
        }
    }
}
