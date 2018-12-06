package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.MeasuredAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.MeasuredAnalysisMonth;
import com.spring.jersy.hibernate.model.service.MeasuredAnalysisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MeasuredAnalysisMonthServiceImpl implements MeasuredAnalysisMonthService {

    @Autowired
    private MeasuredAnalysisMonthDao measuredAnalysisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(MeasuredAnalysisMonth.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("( companyname like '%" + key + "%')"));
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
        pageList = measuredAnalysisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public MeasuredAnalysisMonth findByid(Integer id) {
        return measuredAnalysisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        measuredAnalysisMonthDao.delete(id);
    }

    @Override
    public void save(MeasuredAnalysisMonth measuredAnalysisMonth) {
        measuredAnalysisMonthDao.save(measuredAnalysisMonth);
    }

    @Override
    public void saveOrUpd(MeasuredAnalysisMonth measuredAnalysisMonth) {
        measuredAnalysisMonthDao.saveOrUpdate(measuredAnalysisMonth);
    }
}
