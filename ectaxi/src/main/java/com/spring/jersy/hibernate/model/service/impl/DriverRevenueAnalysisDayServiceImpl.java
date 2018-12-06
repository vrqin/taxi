package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverRevenueAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.DriverRevenueAnalysisDay;
import com.spring.jersy.hibernate.model.service.DriverRevenueAnalysisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverRevenueAnalysisDayServiceImpl implements DriverRevenueAnalysisDayService {

    @Autowired
    private DriverRevenueAnalysisDayDao driverRevenueAnalysisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverRevenueAnalysisDay.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  account like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {

            dc.add(Restrictions.ge("date", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("date", endtime));
        }
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverRevenueAnalysisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverRevenueAnalysisDay findByid(Integer id) {
        return driverRevenueAnalysisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverRevenueAnalysisDayDao.delete(id);
    }

    @Override
    public void save(DriverRevenueAnalysisDay driverRevenueAnalysisDay) {
        driverRevenueAnalysisDayDao.save(driverRevenueAnalysisDay);
    }

    @Override
    public void saveOrUpd(DriverRevenueAnalysisDay driverRevenueAnalysisDay) {
        driverRevenueAnalysisDayDao.saveOrUpdate(driverRevenueAnalysisDay);
    }
}
