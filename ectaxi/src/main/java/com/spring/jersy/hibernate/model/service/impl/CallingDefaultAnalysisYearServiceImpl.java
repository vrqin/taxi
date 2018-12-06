package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CallingDefaultAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.CallingDefaultAnalysisYear;
import com.spring.jersy.hibernate.model.service.CallingDefaultAnalysisYearService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CallingDefaultAnalysisYearServiceImpl implements CallingDefaultAnalysisYearService {

    @Autowired
    private CallingDefaultAnalysisYearDao callingDefaultAnalysisYearDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CallingDefaultAnalysisYear.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(area like '%" + key + "%' )"));
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
        pageList = callingDefaultAnalysisYearDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CallingDefaultAnalysisYear findByid(Integer id) {
        return callingDefaultAnalysisYearDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        callingDefaultAnalysisYearDao.delete(id);
    }

    @Override
    public void save(CallingDefaultAnalysisYear callingDefaultAnalysisYear) {
        callingDefaultAnalysisYearDao.save(callingDefaultAnalysisYear);
    }

    @Override
    public void saveOrUpd(CallingDefaultAnalysisYear callingDefaultAnalysisYear) {
        callingDefaultAnalysisYearDao.saveOrUpdate(callingDefaultAnalysisYear);
    }
}
