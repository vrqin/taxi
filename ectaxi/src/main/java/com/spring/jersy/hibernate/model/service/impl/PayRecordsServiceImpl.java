package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.PayRecordsDao;
import com.spring.jersy.hibernate.model.entity.PayRecords;
import com.spring.jersy.hibernate.model.service.PayRecordsService;
import com.spring.jersy.hibernate.publics.bean.WalletBean;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
@Service
public class PayRecordsServiceImpl implements PayRecordsService {
    @Autowired
    private PayRecordsDao payRecordsDao;

    public static StringBuffer PayRecrodsSql(String account, Integer status) {

        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT orderid,mileage,money,paytime,paystatus FROM `tab_payrecords` WHERE paytime IS NOT NULL AND tradeno IS NOT NULL AND paytype <> 0 ");
        if (!S.isNull(account)) {
            sqllsit.append(" AND account='" + account + "' AND paystatus = " + status);
        }

        return sqllsit;

    }

    public static StringBuffer PayRecrodsWallet() {

        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT account,SUM(money),COUNT(orderid) FROM `tab_payrecords` ");
        sqllsit.append(" WHERE tradeno IS NOT NULL AND (paytype=1 OR paytype=2) AND paystatus = 0 ");
        sqllsit.append(" GROUP BY account ");

        return sqllsit;

    }

    @Override
    public PageList findPageList(int page, int rows, String sort, String order, String key, String begintime, String endtime) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(PayRecords.class);

        dc.add(Restrictions.sqlRestriction("tradeno IS NOT NULL AND paytype <> 0 AND paystatus = 0"));
        if (!S.isNull(key)) {
            dc.add(Restrictions.eq("account", key));
        }
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = payRecordsDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public List<PayRecords> findList(String key) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(PayRecords.class);

        dc.add(Restrictions.sqlRestriction("tradeno IS NOT NULL AND paytype <> 0 AND paystatus = 0"));
        if (!S.isNull(key)) {
            dc.add(Restrictions.eq("account", key));
        }
        dc.addOrder(Order.desc("orderid"));

        return payRecordsDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<PayRecords> findListbyPayRecords(String account, Integer status) {
        StringBuffer sqllsit = PayRecrodsSql(account, status);
        List<Object[]> list = payRecordsDao.findListSql(String.valueOf(sqllsit));
        List<PayRecords> callBusslist = new ArrayList<PayRecords>();
        PayRecords callBean;

        for (Object[] objects : list) {
            callBean = new PayRecords();
            callBean.setOrderid(objects[0] == null ? "" : objects[0].toString());
            callBean.setMileage(objects[1] == null ? 0 : Double.valueOf(objects[1].toString()));
            callBean.setMoney(objects[2] == null ? 0 : Double.valueOf(objects[2].toString()));
            try {
                callBean.setPaytime(objects[3] == null ? null : DateUtil.stringToDate(objects[3].toString(), "yyyy-MM-dd HH:mm:ss"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            callBean.setPaystatus(objects[4] == null ? 0 : Integer.valueOf(objects[4].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<WalletBean> findListbyPayRecordsWallet() {
        StringBuffer sqllsit = PayRecrodsWallet();
        List<Object[]> list = payRecordsDao.findListSql(String.valueOf(sqllsit));
        List<WalletBean> callBusslist = new ArrayList<WalletBean>();
        WalletBean callBean;

        for (Object[] objects : list) {
            callBean = new WalletBean();
            callBean.setAccount(objects[0] == null ? "" : objects[0].toString());
            callBean.setMoney(objects[1] == null ? 0 : Double.valueOf(objects[1].toString()));
            callBean.setOrdernum(objects[2] == null ? 0 : Integer.valueOf(objects[2].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public PayRecords findByid(Integer id) {

        return null;
    }

    @Override
    public PayRecords findByorderid(String orderid) {
        DetachedCriteria dc = DetachedCriteria.forClass(PayRecords.class);
        dc.add(Restrictions.eq("orderid", orderid));
        return payRecordsDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void save(PayRecords passPayDetails) {
        payRecordsDao.save(passPayDetails);
    }

    @Override
    public void saveOrUpd(PayRecords passPayDetails) {
        payRecordsDao.saveOrUpdate(passPayDetails);
    }
}
