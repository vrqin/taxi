package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverRevenueAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.DriverRevenueAnalysisYear;
import com.spring.jersy.hibernate.model.service.DriverRevenueAnalysisYearService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverRevenueAnalysisYearServiceImpl implements DriverRevenueAnalysisYearService {

    @Autowired
    private DriverRevenueAnalysisYearDao driverRevenueAnalysisYearDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverRevenueAnalysisYear.class);


        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  account like '%" + key + "%')"));
        }

        if (!S.isNull(begintime)) {

            dc.add(Restrictions.ge("annual", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("annual", endtime));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverRevenueAnalysisYearDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverRevenueAnalysisYear findByid(Integer id) {
        return driverRevenueAnalysisYearDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverRevenueAnalysisYearDao.delete(id);
    }

    @Override
    public void save(DriverRevenueAnalysisYear driverRevenueAnalysisYear) {
        driverRevenueAnalysisYearDao.save(driverRevenueAnalysisYear);
    }

    @Override
    public void saveOrUpd(DriverRevenueAnalysisYear driverRevenueAnalysisYear) {
        driverRevenueAnalysisYearDao.saveOrUpdate(driverRevenueAnalysisYear);
    }
}
