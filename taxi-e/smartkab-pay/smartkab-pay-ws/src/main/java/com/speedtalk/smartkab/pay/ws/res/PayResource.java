package com.speedtalk.smartkab.pay.ws.res;

import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.smartkab.pay.ws.BaseDao;
import com.speedtalk.smartkab.pay.ws.Constants;
import com.speedtalk.smartkab.pay.ws.KeyUtil;
import com.speedtalk.smartkab.pay.ws.TokenUtil;
import com.speedtalk.smartkab.pay.ws.db.TabPayrecords;
import com.speedtalk.smartkab.pay.ws.domain.PayResponse;
import com.speedtalk.smartkab.pay.ws.service.AliPayService;
import com.speedtalk.smartkab.pay.ws.service.WeChatPayService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.SignatureException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Path("pay")
public class PayResource {
    private static final Logger LOG = Logger.getLogger(PayResource.class.getName());
    private BaseDao dao = new BaseDao();

    @GET
    @Path("query")
    @Produces(MediaType.APPLICATION_JSON)
    public PayResponse getPayResult(@QueryParam("token") String token, @QueryParam("ordernum") String orderNum) {
        PayResponse resp = new PayResponse(Constants.PARAM_ERR_CODE, Constants.PARAM_ERR_DESC, null, null);
        Jws<Claims> claims;
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
        TabPayrecords payrecords = null;
        try {
            payrecords = (TabPayrecords) dao.get(TabPayrecords.class, orderNum);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " order error! " + orderNum);
            return resp;
        }
        if (null == payrecords) {
            resp.setCode(Constants.ORDER_ERR_CODE);
            resp.setDesc(Constants.ORDER_ERR_DESC);
            LOG.info(claims.getBody().getSubject() + " order error! " + orderNum);
            return resp;
        }

        if (payrecords.getPaytype() == OrderMessConstants.ALIPAY_PAY)
            resp = AliPayService.getResult(orderNum);
        else if (payrecords.getPaytype() == OrderMessConstants.WECHAT_PAY)
            resp = WeChatPayService.getResult(orderNum);
        else if (payrecords.getPaytype() == OrderMessConstants.CASH_PAY) {
            resp.setPaytype(String.valueOf(OrderMessConstants.CASH_PAY));
            resp.setAmount(String.valueOf((int) (payrecords.getMoney() * 100)));
            resp.setCode(Constants.SUCCESS_CODE);
            resp.setDesc("现金支付成功");
        } else
            LOG.info(claims.getBody().getSubject() + " unknown pay type! " + resp.toString());
        LOG.info(orderNum + "," + claims.getBody().getSubject() + " order pay result " + resp.toString());
        return resp;
    }
}
