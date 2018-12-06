package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.WithdrawDao;
import com.spring.jersy.hibernate.model.entity.Withdraw;
import com.spring.jersy.hibernate.model.service.WithdrawService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class WithdrawServiceImpl implements WithdrawService {

    @Autowired
    private WithdrawDao withdrawDao;

    public static StringBuffer WithdrarwStatistics() {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT `name`,phone,state,way,cashaccount,SUM(amount),extracttime FROM `tab_withdraw` ");
        sqllsit.append(" GROUP BY extracttime ,`name`,cashaccount ");
        return sqllsit;

    }

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, int state) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Withdraw.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(phone like '%" + key + "%' or name like '%" + key + "%'or cashaccount like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.eq("extracttime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("extracttime", end));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("way", type));
        }

        if (state > (-1)) {
            dc.add(Restrictions.eq("state", state));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = withdrawDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public Withdraw findByid(Integer id) {
        return withdrawDao.get(id);
    }

    @Override
    public Withdraw findByOrderid(String orderid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Withdraw.class);
        dc.add(Restrictions.eq("orderid", orderid));
        return withdrawDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public void delete(Integer id) {
        withdrawDao.delete(id);
    }

    @Override
    public void save(Withdraw withdraw) {
        withdrawDao.save(withdraw);
    }

    @Override
    public void saveOrUpd(Withdraw withdraw) {
        withdrawDao.saveOrUpdate(withdraw);
    }

    @Override
    public List<Withdraw> findListbyWithdrarwStatistics() {
        StringBuffer sqllsit = WithdrarwStatistics();
        List<Object[]> list = withdrawDao.findListSql(String.valueOf(sqllsit));
        List<Withdraw> callBusslist = new ArrayList<Withdraw>();
        Withdraw callBean;

        for (Object[] objects : list) {
            callBean = new Withdraw();
            callBean.setName(objects[0] == null ? null : objects[0].toString());
            callBean.setPhone(objects[1] == null ? null : objects[1].toString());
            callBean.setState(objects[2] == null ? 0 : Integer.valueOf(objects[2].toString()));
            callBean.setWay(objects[3] == null ? 0 : Integer.valueOf(objects[3].toString()));
            callBean.setCashaccount(objects[4] == null ? null : objects[4].toString());
            callBean.setAmount(objects[5] == null ? 0 : Double.valueOf(objects[5].toString()));
            try {
                callBean.setExtracttime(objects[6] == null ? null : DateUtil.stringToDate(objects[6].toString(), "yyyy-MM-dd HH:mm:ss"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            callBusslist.add(callBean);
        }
        return callBusslist;
    }
}
