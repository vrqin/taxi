package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.AverageVelocityAnalysisDao;
import com.spring.jersy.hibernate.model.entity.AverageVelocityAnalysis;
import com.spring.jersy.hibernate.model.service.AverageVelocityAnalysisService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AverageVelocityAnalysisServiceImpl implements AverageVelocityAnalysisService {

    @Autowired
    private AverageVelocityAnalysisDao averageVelocityAnalysisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(AverageVelocityAnalysis.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(area like '%" + key + "%' )"));
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
        pageList = averageVelocityAnalysisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public AverageVelocityAnalysis findByid(Integer id) {
        return averageVelocityAnalysisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        averageVelocityAnalysisDao.delete(id);
    }

    @Override
    public void save(AverageVelocityAnalysis averageVelocityAnalysis) {
        averageVelocityAnalysisDao.save(averageVelocityAnalysis);
    }

    @Override
    public void saveOrUpd(AverageVelocityAnalysis averageVelocityAnalysis) {
        averageVelocityAnalysisDao.saveOrUpdate(averageVelocityAnalysis);
    }
}
