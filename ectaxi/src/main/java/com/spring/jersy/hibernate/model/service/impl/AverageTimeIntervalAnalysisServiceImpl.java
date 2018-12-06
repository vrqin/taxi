package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.AverageTimeIntervalAnalysisDao;
import com.spring.jersy.hibernate.model.entity.AverageTimeIntervalAnalysis;
import com.spring.jersy.hibernate.model.service.AverageTimeIntervalAnalysisService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AverageTimeIntervalAnalysisServiceImpl implements AverageTimeIntervalAnalysisService {

    @Autowired
    private AverageTimeIntervalAnalysisDao averageTimeIntervalAnalysisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(AverageTimeIntervalAnalysis.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  area like '%" + key + "%')"));
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
        pageList = averageTimeIntervalAnalysisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public AverageTimeIntervalAnalysis findByid(Integer id) {
        return averageTimeIntervalAnalysisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        averageTimeIntervalAnalysisDao.delete(id);
    }

    @Override
    public void save(AverageTimeIntervalAnalysis averageTimeIntervalAnalysis) {
        averageTimeIntervalAnalysisDao.save(averageTimeIntervalAnalysis);
    }

    @Override
    public void saveOrUpd(AverageTimeIntervalAnalysis averageTimeIntervalAnalysis) {
        averageTimeIntervalAnalysisDao.saveOrUpdate(averageTimeIntervalAnalysis);
    }
}
