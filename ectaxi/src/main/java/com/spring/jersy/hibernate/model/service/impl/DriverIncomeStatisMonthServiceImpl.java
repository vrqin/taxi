package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverIncomeStatisMonthDao;
import com.spring.jersy.hibernate.model.entity.DriverIncomeStatisMonth;
import com.spring.jersy.hibernate.model.service.DriverIncomeStatisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverIncomeStatisMonthServiceImpl implements DriverIncomeStatisMonthService {

    @Autowired
    private DriverIncomeStatisMonthDao driverIncomeStatisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverIncomeStatisMonth.class);

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
        pageList = driverIncomeStatisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverIncomeStatisMonth findByid(Integer id) {
        return driverIncomeStatisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverIncomeStatisMonthDao.delete(id);
    }

    @Override
    public void save(DriverIncomeStatisMonth driverIncomeStatisMonth) {
        driverIncomeStatisMonthDao.save(driverIncomeStatisMonth);
    }

    @Override
    public void saveOrUpd(DriverIncomeStatisMonth driverIncomeStatisMonth) {
        driverIncomeStatisMonthDao.saveOrUpdate(driverIncomeStatisMonth);
    }
}
