package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.LowSpeedAfterAnalysisDao;
import com.spring.jersy.hibernate.model.entity.LowSpeedAfterAnalysis;
import com.spring.jersy.hibernate.model.service.LowSpeedAfterAnalysisService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LowSpeedAfterAnalysisServiceImpl implements LowSpeedAfterAnalysisService {

    @Autowired
    private LowSpeedAfterAnalysisDao lowSpeedAfterAnalysisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(LowSpeedAfterAnalysis.class);

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
        pageList = lowSpeedAfterAnalysisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public LowSpeedAfterAnalysis findByid(Integer id) {
        return lowSpeedAfterAnalysisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        lowSpeedAfterAnalysisDao.delete(id);
    }

    @Override
    public void save(LowSpeedAfterAnalysis lowSpeedAfterAnalysis) {
        lowSpeedAfterAnalysisDao.save(lowSpeedAfterAnalysis);
    }

    @Override
    public void saveOrUpd(LowSpeedAfterAnalysis lowSpeedAfterAnalysis) {
        lowSpeedAfterAnalysisDao.saveOrUpdate(lowSpeedAfterAnalysis);
    }
}
