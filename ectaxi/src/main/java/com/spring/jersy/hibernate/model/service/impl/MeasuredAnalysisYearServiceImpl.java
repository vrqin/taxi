package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.MeasuredAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.MeasuredAnalysisYear;
import com.spring.jersy.hibernate.model.service.MeasuredAnalysisYearService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MeasuredAnalysisYearServiceImpl implements MeasuredAnalysisYearService {

    @Autowired
    private MeasuredAnalysisYearDao measuredAnalysisYearDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(MeasuredAnalysisYear.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("( companyname like '%" + key + "%')"));
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
        pageList = measuredAnalysisYearDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public MeasuredAnalysisYear findByid(Integer id) {
        return measuredAnalysisYearDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        measuredAnalysisYearDao.delete(id);
    }

    @Override
    public void save(MeasuredAnalysisYear measuredAnalysisYear) {
        measuredAnalysisYearDao.save(measuredAnalysisYear);
    }

    @Override
    public void saveOrUpd(MeasuredAnalysisYear measuredAnalysisYear) {
        measuredAnalysisYearDao.saveOrUpdate(measuredAnalysisYear);
    }
}
