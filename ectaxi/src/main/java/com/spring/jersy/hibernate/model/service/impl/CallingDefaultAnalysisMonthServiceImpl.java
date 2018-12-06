package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CallingDefaultAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.CallingDefaultAnalysisMonth;
import com.spring.jersy.hibernate.model.service.CallingDefaultAnalysisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CallingDefaultAnalysisMonthServiceImpl implements CallingDefaultAnalysisMonthService {

    @Autowired
    private CallingDefaultAnalysisMonthDao callingDefaultAnalysisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CallingDefaultAnalysisMonth.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(area like '%" + key + "%' )"));
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
        pageList = callingDefaultAnalysisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CallingDefaultAnalysisMonth findByid(Integer id) {
        return callingDefaultAnalysisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        callingDefaultAnalysisMonthDao.delete(id);
    }

    @Override
    public void save(CallingDefaultAnalysisMonth callingDefaultAnalysisMonth) {
        callingDefaultAnalysisMonthDao.save(callingDefaultAnalysisMonth);
    }

    @Override
    public void saveOrUpd(CallingDefaultAnalysisMonth callingDefaultAnalysisMonth) {
        callingDefaultAnalysisMonthDao.saveOrUpdate(callingDefaultAnalysisMonth);
    }
}
