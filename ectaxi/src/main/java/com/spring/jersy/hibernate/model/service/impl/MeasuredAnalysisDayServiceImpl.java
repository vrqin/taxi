package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.MeasuredAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.MeasuredAnalysisDay;
import com.spring.jersy.hibernate.model.service.MeasuredAnalysisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MeasuredAnalysisDayServiceImpl implements MeasuredAnalysisDayService {

    @Autowired
    private MeasuredAnalysisDayDao measuredAnalysisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(MeasuredAnalysisDay.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("( companyname like '%" + key + "%')"));
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
        pageList = measuredAnalysisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public MeasuredAnalysisDay findByid(Integer id) {
        return measuredAnalysisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        measuredAnalysisDayDao.delete(id);
    }

    @Override
    public void save(MeasuredAnalysisDay measuredAnalysisDay) {
        measuredAnalysisDayDao.save(measuredAnalysisDay);
    }

    @Override
    public void saveOrUpd(MeasuredAnalysisDay measuredAnalysisDay) {
        measuredAnalysisDayDao.saveOrUpdate(measuredAnalysisDay);
    }
}
