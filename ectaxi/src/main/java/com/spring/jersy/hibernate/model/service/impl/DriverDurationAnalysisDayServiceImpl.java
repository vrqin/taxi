package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverDurationAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.DriverDurationAnalysisDay;
import com.spring.jersy.hibernate.model.service.DriverDurationAnalysisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverDurationAnalysisDayServiceImpl implements DriverDurationAnalysisDayService {

    @Autowired
    private DriverDurationAnalysisDayDao driverDurationAnalysisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverDurationAnalysisDay.class);

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
        pageList = driverDurationAnalysisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverDurationAnalysisDay findByid(Integer id) {
        return driverDurationAnalysisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverDurationAnalysisDayDao.delete(id);
    }

    @Override
    public void save(DriverDurationAnalysisDay driverDurationAnalysisDay) {
        driverDurationAnalysisDayDao.save(driverDurationAnalysisDay);
    }

    @Override
    public void saveOrUpd(DriverDurationAnalysisDay driverDurationAnalysisDay) {
        driverDurationAnalysisDayDao.saveOrUpdate(driverDurationAnalysisDay);
    }
}
