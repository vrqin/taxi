package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverRevenueAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.DriverRevenueAnalysisMonth;
import com.spring.jersy.hibernate.model.service.DriverRevenueAnalysisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverRevenueAnalysisMonthServiceImpl implements DriverRevenueAnalysisMonthService {

    @Autowired
    private DriverRevenueAnalysisMonthDao driverRevenueAnalysisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverRevenueAnalysisMonth.class);


        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  account like '%" + key + "%')"));
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
        pageList = driverRevenueAnalysisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverRevenueAnalysisMonth findByid(Integer id) {
        return driverRevenueAnalysisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverRevenueAnalysisMonthDao.delete(id);
    }

    @Override
    public void save(DriverRevenueAnalysisMonth driverRevenueAnalysisMonth) {
        driverRevenueAnalysisMonthDao.save(driverRevenueAnalysisMonth);
    }

    @Override
    public void saveOrUpd(DriverRevenueAnalysisMonth driverRevenueAnalysisMonth) {
        driverRevenueAnalysisMonthDao.saveOrUpdate(driverRevenueAnalysisMonth);
    }
}
