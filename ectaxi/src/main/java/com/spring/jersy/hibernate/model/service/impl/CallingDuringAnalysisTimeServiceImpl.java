package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CallingDuringAnalysisTimeDao;
import com.spring.jersy.hibernate.model.entity.CallingDuringAnalysisTime;
import com.spring.jersy.hibernate.model.service.CallingDuringAnalysisTimeService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CallingDuringAnalysisTimeServiceImpl implements CallingDuringAnalysisTimeService {

    @Autowired
    private CallingDuringAnalysisTimeDao callingDuringAnalysisTimeDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CallingDuringAnalysisTime.class);

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
        pageList = callingDuringAnalysisTimeDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CallingDuringAnalysisTime findByid(Integer id) {
        return callingDuringAnalysisTimeDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        callingDuringAnalysisTimeDao.delete(id);
    }

    @Override
    public void save(CallingDuringAnalysisTime callingDuringAnalysisTime) {
        callingDuringAnalysisTimeDao.save(callingDuringAnalysisTime);
    }

    @Override
    public void saveOrUpd(CallingDuringAnalysisTime callingDuringAnalysisTime) {
        callingDuringAnalysisTimeDao.saveOrUpdate(callingDuringAnalysisTime);
    }
}
