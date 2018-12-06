package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CallingPeakAnalyzedMonthDao;
import com.spring.jersy.hibernate.model.entity.CallingPeakAnalyzedMonth;
import com.spring.jersy.hibernate.model.service.CallingPeakAnalyzedMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CallingPeakAnalyzedMonthServiceImpl implements CallingPeakAnalyzedMonthService {

    @Autowired
    private CallingPeakAnalyzedMonthDao callingPeakAnalyzedMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CallingPeakAnalyzedMonth.class);

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
        pageList = callingPeakAnalyzedMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CallingPeakAnalyzedMonth findByid(Integer id) {
        return callingPeakAnalyzedMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        callingPeakAnalyzedMonthDao.delete(id);
    }

    @Override
    public void save(CallingPeakAnalyzedMonth callingPeakAnalyzedMonth) {
        callingPeakAnalyzedMonthDao.save(callingPeakAnalyzedMonth);
    }

    @Override
    public void saveOrUpd(CallingPeakAnalyzedMonth callingPeakAnalyzedMonth) {
        callingPeakAnalyzedMonthDao.saveOrUpdate(callingPeakAnalyzedMonth);
    }
}
