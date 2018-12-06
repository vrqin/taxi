package com.speedtalk.smartkab.pay.ws.res;

import com.speedtalk.smartkab.pay.ws.BaseDao;
import com.speedtalk.smartkab.pay.ws.Constants;
import com.speedtalk.smartkab.pay.ws.KeyUtil;
import com.speedtalk.smartkab.pay.ws.TokenUtil;
import com.speedtalk.smartkab.pay.ws.db.TabPhoneuser;
import com.speedtalk.smartkab.pay.ws.domain.TokenReq;
import com.speedtalk.smartkab.pay.ws.domain.TokenResp;
import com.speedtalk.smartkab.pay.ws.domain.WechatTokenReq;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.logging.Logger;

@Path("token")
public class TokenResource {
    private Logger log = Logger.getLogger(TokenResource.class.getName());
    private BaseDao dao = new BaseDao();

    @POST
    @Path("gettoken")
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * 乘客用户获取token
     * @param req
     * @return
     */ public TokenResp getPasserToken(TokenReq req) {
        TokenResp resp = new TokenResp(Constants.SUCCESS_CODE, Constants.SUCCESS_DESC, null);
        if (null == req) {
            resp.setCode(Constants.PARAM_ERR_CODE);
            resp.setDesc(Constants.PARAM_ERR_DESC);
            log.info("param is null!");
            return resp;
        }
        TabPhoneuser user = (TabPhoneuser) dao.get(TabPhoneuser.class, req.getAccount());
        String pwd;
        try {
            pwd = user.getPassword();
        } catch (NullPointerException npe) {
            resp.setCode(Constants.USER_ERR_CODE);
            resp.setDesc(Constants.USER_ERR_DESC);
            log.info(req.getAccount() + " user err!");
            return resp;
        }
        if (pwd != null && pwd.equals(req.getPwd())) {
            Calendar expiry = Calendar.getInstance();
            expiry.add(Calendar.MINUTE, 30);    //设置有效期30分钟
            resp.setToken(TokenUtil.getJwtToken(req.getAccount(), expiry, KeyUtil.getInstance().getKey()));
            log.info(req.getAccount() + " getPasserToken --> " + resp.getToken());
            return resp;
        } else {
            resp.setCode(Constants.USER_ERR_CODE);
            resp.setDesc(Constants.USER_ERR_DESC);
            log.info(req.getAccount() + " pwd err!");
            return resp;
        }
    }

    @POST
    @Path("getwctoken")
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * 公众号获取token
     * @param req
     * @return
     */ public TokenResp getWechatToken(WechatTokenReq req) {
        TokenResp resp = new TokenResp(Constants.SUCCESS_CODE, Constants.SUCCESS_DESC, null);
        if (null == req) {
            resp.setCode(Constants.PARAM_ERR_CODE);
            resp.setDesc(Constants.PARAM_ERR_DESC);
            log.info("param is null!");
            return resp;
        }
        TabPhoneuser user = (TabPhoneuser) dao.get(TabPhoneuser.class, req.getAccount());
        String openid = null;
        try {
            openid = user.getOpenId();
        } catch (NullPointerException npe) {
            resp.setCode(Constants.USER_ERR_CODE);
            resp.setDesc(Constants.USER_ERR_DESC);
            log.info(req.getAccount() + " user err!");
            return resp;
        }
        if (openid != null && openid.equals(req.getOpenid())) {
            Calendar expiry = Calendar.getInstance();
            expiry.add(Calendar.MINUTE, 30);    //设置有效期30分钟
            resp.setToken(TokenUtil.getJwtToken(req.getAccount(), expiry, KeyUtil.getInstance().getKey()));
            log.info(req.getAccount() + " getWechatToken --> " + resp.getToken());
            return resp;
        } else {
            resp.setCode(Constants.OPENID_ERR);
            resp.setDesc(Constants.OPENID_ERR_DESC);
            log.info(req.getAccount() + " openid err!");
            return resp;
        }
    }
}
