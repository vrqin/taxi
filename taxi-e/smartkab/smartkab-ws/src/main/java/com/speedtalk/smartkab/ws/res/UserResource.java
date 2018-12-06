package com.speedtalk.smartkab.ws.res;

import com.speedtalk.smartkab.ws.Constants;
import com.speedtalk.smartkab.ws.Utils;
import com.speedtalk.smartkab.ws.ValidateCode;
import com.speedtalk.smartkab.ws.ValidateCodeStorer;
import com.speedtalk.smartkab.ws.dao.BaseDao;
import com.speedtalk.smartkab.ws.dao.UserDao;
import com.speedtalk.smartkab.ws.db.TabPhoneuser;
import com.speedtalk.smartkab.ws.domain.*;
import org.hibernate.HibernateException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.ws.rs.*;
import java.sql.Timestamp;

@Path("user")
public class UserResource {
    private BaseDao dao;
    private UserDao userDao;

    public UserResource() {
        dao = new BaseDao();
        userDao = new UserDao();
    }

    @POST
    @Path("register")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    /**
     * register user
     * if user's phone unregistered,register a new user.
     * @param info
     * @return register result
     */ public Response register(final User info) {
        Response response = new Response(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        if (null == info || (null == info.getAccount() || info.getAccount().trim().equals(""))) {
            response.setCode(Constants.REG_FAILURE_RESP);
            response.setDesc(Constants.REG_FAILURE_DESC_RESP);
            System.out.println(Utils.getLogFix() + info.getAccount() + " account null for register!");
            return response;
        }

        if (info.getCode() != null) {
            ValidateCode validateCode = ValidateCodeStorer.get(info.getAccount());
            if (null == validateCode) {
                response.setCode(Constants.CODE_ERROR_RESP);
                response.setDesc(Constants.CODE_ERROR_DESC_RESP);
                System.out.println(Utils.getLogFix() + info.getAccount() + "," + response.getDesc());
                return response;
            }
            long time = System.currentTimeMillis();
            if (time - validateCode.getTime() > ValidateCodeStorer.VALIDATE_CODE_TIME_OUT) {
                response.setCode(Constants.CODE_TIMEOUT_RESP);
                response.setDesc(Constants.CODE_TIMEOUT_DESC_RESP);
                ValidateCodeStorer.delete(info.getAccount());
                System.out.println(Utils.getLogFix() + info.getAccount() + "," + response.getDesc());
                return response;
            }
            if (!validateCode.getCode().equals(info.getCode())) {
                response.setCode(Constants.CODE_ERROR_RESP);
                response.setDesc(Constants.CODE_ERROR_DESC_RESP);
                System.out.println(Utils.getLogFix() + info.getAccount() + "," + response.getDesc());
                return response;
            }
        }

        String temp = info.getAccount().trim();
        TabPhoneuser tUser = userDao.getByAccount(temp);
        if (tUser == null) {
            tUser = new TabPhoneuser();
            tUser.setTabEnterpriseInfo(1);
            tUser.setOpruser(temp);
            temp = info.getPhone() == null ? info.getPhone() : info.getPhone().trim();
            tUser.setMobile(temp);
            temp = info.getName() == null ? info.getName() : info.getName().trim();
            tUser.setName(temp);
            tUser.setSex(info.getGender());
            temp = info.getPwd() == null ? info.getPwd() : info.getPwd().trim();
            tUser.setPassword(temp);
            tUser.setCreatedate(new Timestamp(System.currentTimeMillis()));
            temp = info.getOpenid() == null ? info.getOpenid() : info.getOpenid().trim();
            tUser.setOpenId(temp);
            try {
                userDao.saveOrUpdate(tUser);
                ValidateCodeStorer.delete(info.getAccount());
            } catch (HibernateException he) {
                response.setCode(Constants.REG_FAILURE_RESP);
                response.setDesc(Constants.REG_FAILURE_DESC_RESP);
                System.out.println(Utils.getLogFix() + info.getAccount() + " register exception!");
                return response;
            }
            System.out.println(Utils.getLogFix() + info.getAccount() + " register success!");
        } else {
            temp = info.getOpenid();
            System.out.println(Utils.getLogFix() + " openid:" + temp);
            if (temp != null && temp.trim().length() > 0) {
                tUser.setOpenId(temp.trim());
                try {
                    userDao.saveOrUpdate(tUser);
                    ValidateCodeStorer.delete(info.getAccount());
                    System.out.println(Utils.getLogFix() + info.getAccount() + " has registered,update wechatID!");
                } catch (HibernateException he) {
                    response.setCode(Constants.REG_FAILURE_RESP);
                    response.setDesc(Constants.REG_FAILURE_DESC_RESP);
                    System.out.println(Utils.getLogFix() + info.getAccount() + " register exception!");
                    return response;
                }
            } else {
                response.setCode(Constants.REGISTERED_RESP);
                response.setDesc(Constants.REGISTERED_DESC_RESP);
                System.out.println(Utils.getLogFix() + info.getPhone() + " has registered!");
            }
        }
        return response;
    }

    @PUT
    @Path("updateuser")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    /**
     * update user info
     * @param info
     * @return when success return Constants.SUCCESS_RESP.otherwise return other.
     */ public Response updateUser(final UserInfo info) {
        Response response = new Response(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        TabPhoneuser tbUser = userDao.getByAccount(info.getAccount());
        if (null == tbUser) {
            System.out.println(Utils.getLogFix() + info.getAccount() + " updateInfo,account error!");
            response.setCode(Constants.ACCOUNT_ERR_RESP);
            response.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
            return response;
        } else {
            String temp = info.getName() == null ? info.getName() : info.getName().trim();
            if (temp != null && !temp.equals(tbUser.getName()))
                tbUser.setName(temp);
            tbUser.setSex(info.getGender());
            temp = info.getPhone() == null ? info.getPhone() : info.getPhone().trim();
            if (temp != null && !temp.equals(tbUser.getMobile()))
                tbUser.setMobile(temp);
            try {
                userDao.saveOrUpdate(tbUser);
                System.out.println(Utils.getLogFix() + info.getAccount() + " update user info!");
            } catch (HibernateException he) {
                System.out.println(Utils.getLogFix() + info.getAccount() + " updateInfo exception!");
                response.setCode(Constants.FAILURE_RESP);
                response.setDesc(Constants.FAILURE_DESC_RESP);
                return response;
            }
        }
        return response;
    }

    @PUT
    @Path("updatepwd")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    /**
     * update password
     * @param pwd
     * @return when success return Constants.SUCCESS_RESP.otherwise return other.
     */ public Response updatePwd(final PwdInfo pwd) {
        Response response = new Response(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        TabPhoneuser tbUser = userDao.getByAccount(pwd.getAccount());
        if (null == tbUser) {
            System.out.println(Utils.getLogFix() + pwd.getAccount() + " updatePwd,account error!");
            response.setCode(Constants.ACCOUNT_ERR_RESP);
            response.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
            return response;
        } else {
            String temp = pwd.getOldPwd() == null ? pwd.getOldPwd() : pwd.getOldPwd().trim();
            if (!temp.equals(tbUser.getPassword())) {
                System.out.println(Utils.getLogFix() + pwd.getAccount() + " updatePwd,old pwd error!" + temp);
                response.setCode(Constants.O_PWD_FAILURE_RESP);
                response.setDesc(Constants.O_PWD_FAILURE_DESC_RESP);
                return response;
            }
            temp = pwd.getNewPwd() == null ? pwd.getNewPwd() : pwd.getNewPwd().trim();
            if (null == temp || temp.equals("")) {
                System.out.println(Utils.getLogFix() + pwd.getAccount() + " updatePwd,new pwd is null!");
                response.setCode(Constants.N_PWD_FAILURE_RESP);
                response.setDesc(Constants.N_PWD_FAILURE_DESC_RESP);
                return response;
            }
            try {
                tbUser.setPassword(temp);
                userDao.saveOrUpdate(tbUser);
                System.out.println(Utils.getLogFix() + pwd.getAccount() + " update pwd!");
            } catch (HibernateException he) {
                System.out.println(Utils.getLogFix() + pwd.getAccount() + " update pwd exception!");
                response.setCode(Constants.FAILURE_RESP);
                response.setDesc(Constants.FAILURE_DESC_RESP);
                return response;
            }
        }
        return response;
    }

    @GET
    @Path("login")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    /**
     * @param account
     * @param pwd
     * @return
     */ public UserResp login(@QueryParam("account") final String account, @QueryParam("pwd") final String pwd) {
        TabPhoneuser tbUser = userDao.getByAccount(account, pwd);
        UserResp user = new UserResp();
        if (null == tbUser) {
            user.setCode(Constants.ACCOUNT_PWD_ERR_RESP);
            user.setDesc(Constants.ACCOUNT_PWD_ERR_DESC_RESP);
            System.out.println(Utils.getLogFix() + account + " failure login!");
        } else {
            user.setCode(Constants.SUCCESS_RESP);
            user.setDesc(Constants.SUCCESS_DESC_RESP);
            user.setName(tbUser.getName());
            user.setGender(tbUser.getSex().byteValue());
            user.setPhone(tbUser.getMobile());
            System.out.println(Utils.getLogFix() + account + " login success!");
        }
        return user;
    }

    @GET
    @Path("wechatlogin")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    /**
     * @param account
     * @param pwd
     * @return
     */ public UserResp wechatLogin(@QueryParam("openid") final String openid) {
        UserResp user = new UserResp();
        if (null == openid || openid.trim().equals("")) {
            user.setCode(Constants.ACCOUNT_PWD_ERR_RESP);
            user.setDesc(Constants.ACCOUNT_PWD_ERR_DESC_RESP);
            System.out.println(Utils.getLogFix() + openid + " failure login!");
        }
        DetachedCriteria dc = DetachedCriteria.forClass(TabPhoneuser.class);
        dc.add(Restrictions.eq("openId", openid));
        TabPhoneuser tbUser = (TabPhoneuser) dao.findObjByDetachedCriteria(dc);
        if (null == tbUser) {
            user.setCode(Constants.ACCOUNT_PWD_ERR_RESP);
            user.setDesc(Constants.ACCOUNT_PWD_ERR_DESC_RESP);
            System.out.println(Utils.getLogFix() + openid + " failure login!");
        } else {
            user.setCode(Constants.SUCCESS_RESP);
            user.setDesc(Constants.SUCCESS_DESC_RESP);
            user.setName(tbUser.getName());
            user.setGender(tbUser.getSex().byteValue());
            user.setPhone(tbUser.getOpruser());
            System.out.println(Utils.getLogFix() + openid + " login success! " + tbUser.getOpruser());
        }
        return user;
    }

    @POST
    @Path("reset")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    /**
     * reset password
     * @param pwd
     * @return when success return Constants.SUCCESS_RESP.otherwise return other.
     */ public Response reset(final ResetPwd pwd) {
        Response response = new Response(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        TabPhoneuser tbUser = userDao.getByAccount(pwd.getAccount());
        if (null == tbUser) {
            System.out.println(Utils.getLogFix() + pwd.getAccount() + " reset,account error!");
            response.setCode(Constants.ACCOUNT_ERR_RESP);
            response.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
            return response;
        } else {
            if (null == pwd.getPwd() || pwd.getPwd().trim().equals("")) {
                System.out.println(Utils.getLogFix() + pwd.getAccount() + " reset pwd,pwd is null!");
                response.setCode(Constants.N_PWD_FAILURE_RESP);
                response.setDesc(Constants.N_PWD_FAILURE_DESC_RESP);
                return response;
            }
            ValidateCode validateCode = ValidateCodeStorer.get(pwd.getAccount());
            if (null == validateCode) {
                System.out.println(Utils.getLogFix() + pwd.getAccount() + " reset pwd,code error!");
                response.setCode(Constants.CODE_ERROR_RESP);
                response.setDesc(Constants.CODE_ERROR_DESC_RESP);
                return response;
            }
            if (ValidateCodeStorer.isTimeout(validateCode)) {
                System.out.println(Utils.getLogFix() + pwd.getAccount() + " reset pwd,code is timeout!");
                response.setCode(Constants.CODE_TIMEOUT_RESP);
                response.setDesc(Constants.CODE_TIMEOUT_DESC_RESP);
                ValidateCodeStorer.delete(pwd.getAccount());
                return response;
            }
            if (validateCode.getCode().equals(pwd.getCode().trim())) {
                try {
                    tbUser.setPassword(pwd.getPwd());
                    userDao.saveOrUpdate(tbUser);
                    ValidateCodeStorer.delete(pwd.getAccount());
                    System.out.println(Utils.getLogFix() + pwd.getAccount() + " reset pwd!");
                    return response;
                } catch (HibernateException he) {
                    System.out.println(Utils.getLogFix() + pwd.getAccount() + " reset pwd exception!");
                    response.setCode(Constants.FAILURE_RESP);
                    response.setDesc(Constants.FAILURE_DESC_RESP);
                    return response;
                }
            } else {
                System.out.println(Utils.getLogFix() + pwd.getAccount() + " reset pwd,code error!");
                response.setCode(Constants.CODE_ERROR_RESP);
                response.setDesc(Constants.CODE_ERROR_DESC_RESP);
                return response;
            }
        }
    }
}
