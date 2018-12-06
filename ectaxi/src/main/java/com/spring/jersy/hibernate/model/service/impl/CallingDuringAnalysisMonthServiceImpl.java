package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CallingDuringAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.CallingDuringAnalysisMonth;
import com.spring.jersy.hibernate.model.service.CallingDuringAnalysisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CallingDuringAnalysisMonthServiceImpl implements CallingDuringAnalysisMonthService {

    @Autowired
    private CallingDuringAnalysisMonthDao callingDuringAnalysisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CallingDuringAnalysisMonth.class);

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
        pageList = callingDuringAnalysisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CallingDuringAnalysisMonth findByid(Integer id) {
        return callingDuringAnalysisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        callingDuringAnalysisMonthDao.delete(id);
    }

    @Override
    public void save(CallingDuringAnalysisMonth callingDuringAnalysisMonth) {
        callingDuringAnalysisMonthDao.save(callingDuringAnalysisMonth);
    }

    @Override
    public void saveOrUpd(CallingDuringAnalysisMonth callingDuringAnalysisMonth) {
        callingDuringAnalysisMonthDao.saveOrUpdate(callingDuringAnalysisMonth);
    }
}
