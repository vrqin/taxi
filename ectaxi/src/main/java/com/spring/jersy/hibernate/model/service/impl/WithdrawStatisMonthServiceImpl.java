package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.WithdrawStatisMonthDao;
import com.spring.jersy.hibernate.model.entity.WithdrawStatisMonth;
import com.spring.jersy.hibernate.model.service.WithdrawStatisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WithdrawStatisMonthServiceImpl implements WithdrawStatisMonthService {

    @Autowired
    private WithdrawStatisMonthDao withdrawStatisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(WithdrawStatisMonth.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  company like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {

            dc.add(Restrictions.ge("month", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("month", endtime));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = withdrawStatisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public WithdrawStatisMonth findByid(Integer id) {
        return withdrawStatisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        withdrawStatisMonthDao.delete(id);
    }

    @Override
    public void save(WithdrawStatisMonth withdrawStatisMonth) {
        withdrawStatisMonthDao.save(withdrawStatisMonth);
    }

    @Override
    public void saveOrUpd(WithdrawStatisMonth withdrawStatisMonth) {
        withdrawStatisMonthDao.saveOrUpdate(withdrawStatisMonth);
    }
}
