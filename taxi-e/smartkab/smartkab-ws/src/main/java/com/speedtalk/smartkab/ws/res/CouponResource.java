package com.speedtalk.smartkab.ws.res;

import com.speedtalk.smartkab.ws.Constants;
import com.speedtalk.smartkab.ws.Utils;
import com.speedtalk.smartkab.ws.dao.BaseDao;
import com.speedtalk.smartkab.ws.dao.UserDao;
import com.speedtalk.smartkab.ws.db.TabDiscountCoupon;
import com.speedtalk.smartkab.ws.db.TabDiscountPassenger;
import com.speedtalk.smartkab.ws.db.TabPhoneuser;
import com.speedtalk.smartkab.ws.domain.CheckCoupon;
import com.speedtalk.smartkab.ws.domain.Coupon;
import com.speedtalk.smartkab.ws.domain.CouponAddr;
import com.speedtalk.smartkab.ws.domain.Response;
import com.speedtalk.utils.LoadXmlConfig;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.ws.rs.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Path("coupon")
public class CouponResource {
    private static final String CHECK = "1";    //已领取
    private static final String EXPIRE = "1";    //已过期
    private static final long ONE_DAY_MILLIS = 86400000;
    private static final SimpleDateFormat DAY_SDF = new SimpleDateFormat("yyyy-MM-dd");
    private BaseDao baseDao;
    private UserDao userDao;

    public CouponResource() {
        baseDao = new BaseDao();
        userDao = new UserDao();
    }

    @GET
    @Produces("application/json;charset=utf-8")
    /**
     * 获取未使用过的优惠券
     * @param account
     * @param ischeck
     * @param expire
     * @return
     */ public List<Coupon> getCoupons(@QueryParam("account") final String account, @QueryParam("ischeck") final String ischeck, @QueryParam("expire") final String expire) {
        List<Coupon> list = new ArrayList<Coupon>();
        Coupon coupon = null;
        if (null == account || null == ischeck || ischeck.trim().equals("") || null == expire || expire.trim()
                .equals("")) {
            System.out.println(Utils.getLogFix() + (null == account ? null : account) + " get coupons,param error!");
            coupon = new Coupon();
            coupon.setCode(String.valueOf(Constants.PARAM_ERR_RESP));
            coupon.setDesc(Constants.PARAM_ERR_DESC_RESP);
            list.add(coupon);
            return list;
        }
        TabPhoneuser tbUser = userDao.getByAccount(account);
        if (null == tbUser) {
            System.out.println(Utils.getLogFix() + account + " get coupons,account error!");
            coupon = new Coupon();
            coupon.setCode(String.valueOf(Constants.ACCOUNT_ERR_RESP));
            coupon.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
            list.add(coupon);
            return list;
        }
        String tempAccount = account.replaceAll("(?i)delete|(?i)select|(?i)update", "");
        String sql = null;
        if (CHECK.equals(ischeck.trim()))    //已领取的优惠券
        {
            if (EXPIRE.equals(expire.trim()))    //过期的优惠券
            {
                sql = "SELECT c.id,c.type,c.money,p.isreceive,p.endtime,c.maxDeduction,c.serviceConditions,c.starttime " + "FROM tab_discount_coupon c,tab_discount_passenger p " + "where c.id = p.discid and p.endtime < NOW() " + "and p.isreceive=1 and p.opruser='" + tempAccount + "'";
            } else    //未过期的优惠券
            {
                sql = "SELECT c.id,c.type,c.money,p.isreceive,p.endtime,c.maxDeduction,c.serviceConditions,c.starttime " + "FROM tab_discount_coupon c,tab_discount_passenger p " + "where c.id = p.discid and p.endtime > NOW() " + "and p.isuse = 0 and p.isreceive=1 and p.opruser='" + tempAccount + "'";
            }
        } else    //未领取的优惠券
        {
            sql = "SELECT c.id,c.type,c.money,p.isreceive,c.endtime,c.maxDeduction,c.serviceConditions,c.starttime " + "FROM tab_discount_coupon c,tab_discount_passenger p " + "where c.id = p.discid and c.endtime > NOW() and p.isuse = 0 " + "and p.isreceive=0 and p.opruser='" + tempAccount + "'";
        }

        List<Object[]> ol = baseDao.findBySql(sql);
        if (null == ol || ol.isEmpty())
            System.out.println(Utils.getLogFix() + account + " get no coupons!");
        else {
            for (Object[] o : ol) {
                try {
                    coupon = new Coupon();
                    coupon.setCouponid(String.valueOf(o[0]));
                    coupon.setType(String.valueOf(o[1]));
                    coupon.setValue(String.valueOf(o[2]));
                    coupon.setIscheck(String.valueOf(o[3]));
                    coupon.setExpire(DAY_SDF.format((Timestamp) o[4]));
                    coupon.setDeduction(String.valueOf(o[5]));
                    coupon.setCondition(String.valueOf(o[6]));
                    coupon.setStarttime(DAY_SDF.format((Timestamp) o[7]));
                    list.add(coupon);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Utils.getLogFix() + account + " get coupons!" + list.size());
        }
        return list;
    }

    @GET
    @Path("addr")
    @Produces("application/json;charset=utf-8")
    /**
     * 获取活动地址
     * @param account
     * @return
     */ public List<CouponAddr> getCouponAddr(@QueryParam("account") final String account) {
        List<CouponAddr> list = new ArrayList<CouponAddr>();
        CouponAddr addr = null;
        TabPhoneuser tbUser = userDao.getByAccount(account);
        if (null == tbUser) {
            System.out.println(Utils.getLogFix() + account + " get couponaddr,account error!");
            addr = new CouponAddr();
            addr.setCode(String.valueOf(Constants.ACCOUNT_ERR_RESP));
            addr.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
            list.add(addr);
            return list;
        }
        String tempAccount = account.replaceAll("(?i)delete|(?i)select|(?i)update", "");
        String sql = "SELECT c.id,c.name,c.discountAddr,c.discountPic " + "FROM tab_discount_coupon c,tab_discount_passenger p " + "where c.id = p.discid and c.endtime > NOW() and p.isuse = 0 " + "and c.discountAddr is not null and c.discountPic is not null " + "and p.isreceive=0 and p.opruser='" + tempAccount + "'";

        List<Object[]> ol = baseDao.findBySql(sql);
        if (null == ol || ol.isEmpty())
            System.out.println(Utils.getLogFix() + account + " get no couponaddr!");
        else {
            for (Object[] o : ol) {
                try {
                    addr = new CouponAddr();
                    addr.setTitle(String.valueOf(o[1]));
                    addr.setPageurl(LoadXmlConfig.getConfigHash().get("server-addr") + String.valueOf(o[2]));
                    addr.setPicurl(LoadXmlConfig.getConfigHash().get("server-addr") + String.valueOf(o[3]));
                    list.add(addr);
                } catch (Exception e) {
                }
            }
            System.out.println(Utils.getLogFix() + account + " get couponaddrs!" + list.size());
        }
        return list;
    }

    @PUT
    @Path("check")
    @Produces("application/json;charset=utf-8")
    public Response checkCoupon(final CheckCoupon checkCoupon) {
        Response resp = new Response(Constants.SUCCESS_RESP, null);
        try {
            if (null == checkCoupon) {
                System.out.println(Utils.getLogFix() + " check coupon,param error!");
                resp.setCode(Constants.PARAM_ERR_RESP);
                resp.setDesc(Constants.PARAM_ERR_DESC_RESP);
                return resp;
            }
            TabPhoneuser tbUser = userDao.getByAccount(checkCoupon.getAccount());
            if (null == tbUser) {
                System.out.println(Utils.getLogFix() + checkCoupon.getAccount() + " check coupon,account error!");
                resp.setCode(Constants.ACCOUNT_ERR_RESP);
                resp.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
                return resp;
            }
            DetachedCriteria dc = DetachedCriteria.forClass(TabDiscountPassenger.class);
            dc.add(Restrictions.eq("opruser", checkCoupon.getAccount()));
            dc.add(Restrictions.eq("discid", checkCoupon.getCouponid()));
            TabDiscountPassenger p = (TabDiscountPassenger) baseDao.findObjByDetachedCriteria(dc);
            if (null == p) {
                System.out.println(Utils.getLogFix() + " check coupon,can't find coupon record!" + checkCoupon.toString());
                resp.setCode(Constants.PARAM_ERR_RESP);
                resp.setDesc(Constants.PARAM_ERR_DESC_RESP);
                return resp;
            }
            TabDiscountCoupon c = (TabDiscountCoupon) baseDao.get(TabDiscountCoupon.class, p.getDiscid());
            if (null == c) {
                System.out.println(Utils.getLogFix() + " check coupon,can't find coupon!" + checkCoupon.toString());
                resp.setCode(Constants.PARAM_ERR_RESP);
                resp.setDesc(Constants.PARAM_ERR_DESC_RESP);
                return resp;
            }

            if (checkCoupon.getType() != null && "1".equals(checkCoupon.getType())) {
                p.setIsuse(1);
            } else {
                p.setIsreceive(1);
                long endTimeMillis = c.getValid() * ONE_DAY_MILLIS + System.currentTimeMillis();
                p.setEndtime(new Timestamp(endTimeMillis));
            }

            baseDao.update(p);
            System.out.println(Utils.getLogFix() + " check coupon success!" + checkCoupon.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}
