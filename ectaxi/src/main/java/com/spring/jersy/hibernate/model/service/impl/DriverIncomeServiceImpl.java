package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverIncomeDao;
import com.spring.jersy.hibernate.model.entity.DriverIncome;
import com.spring.jersy.hibernate.model.service.DriverIncomeService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class DriverIncomeServiceImpl implements DriverIncomeService {

    @Autowired
    private DriverIncomeDao driverIncomeDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverIncome.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(driverphone like '%" + key + "%' or drivername like '%" + key + "%' or kabnum like '%" + key + "%'  or passname like '%" + key + "%'  or passphone like '%" + key + "%'  or ordernum like '%" + key + "%' )"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("incometime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("incometime", end));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("payment", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverIncomeDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverIncome findByid(Integer id) {
        return driverIncomeDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverIncomeDao.delete(id);
    }

    @Override
    public void save(DriverIncome driverIncome) {
        driverIncomeDao.save(driverIncome);
    }

    @Override
    public void saveOrUpd(DriverIncome driverIncome) {
        driverIncomeDao.saveOrUpdate(driverIncome);
    }
}
