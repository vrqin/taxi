package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverDurationAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.DriverDurationAnalysisMonth;
import com.spring.jersy.hibernate.model.service.DriverDurationAnalysisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverDurationAnalysisMonthServiceImpl implements DriverDurationAnalysisMonthService {

    @Autowired
    private DriverDurationAnalysisMonthDao driverDurationAnalysisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverDurationAnalysisMonth.class);

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
        pageList = driverDurationAnalysisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverDurationAnalysisMonth findByid(Integer id) {
        return driverDurationAnalysisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverDurationAnalysisMonthDao.delete(id);
    }

    @Override
    public void save(DriverDurationAnalysisMonth driverDurationAnalysisMonth) {
        driverDurationAnalysisMonthDao.save(driverDurationAnalysisMonth);
    }

    @Override
    public void saveOrUpd(DriverDurationAnalysisMonth driverDurationAnalysisMonth) {
        driverDurationAnalysisMonthDao.saveOrUpdate(driverDurationAnalysisMonth);
    }
}
