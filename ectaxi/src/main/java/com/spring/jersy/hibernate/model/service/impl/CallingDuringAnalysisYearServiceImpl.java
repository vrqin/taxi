package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CallingDuringAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.CallingDuringAnalysisYear;
import com.spring.jersy.hibernate.model.service.CallingDuringAnalysisYearService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CallingDuringAnalysisYearServiceImpl implements CallingDuringAnalysisYearService {

    @Autowired
    private CallingDuringAnalysisYearDao callingDuringAnalysisYearDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CallingDuringAnalysisYear.class);

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
        pageList = callingDuringAnalysisYearDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CallingDuringAnalysisYear findByid(Integer id) {
        return callingDuringAnalysisYearDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        callingDuringAnalysisYearDao.delete(id);
    }

    @Override
    public void save(CallingDuringAnalysisYear callingDuringAnalysisYear) {
        callingDuringAnalysisYearDao.save(callingDuringAnalysisYear);
    }

    @Override
    public void saveOrUpd(CallingDuringAnalysisYear callingDuringAnalysisYear) {
        callingDuringAnalysisYearDao.saveOrUpdate(callingDuringAnalysisYear);
    }
}
