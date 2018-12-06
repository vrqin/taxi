package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CallingPeakAnalyzedYearDao;
import com.spring.jersy.hibernate.model.entity.CallingPeakAnalyzedYear;
import com.spring.jersy.hibernate.model.service.CallingPeakAnalyzedYearService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CallingPeakAnalyzedYearServiceImpl implements CallingPeakAnalyzedYearService {

    @Autowired
    private CallingPeakAnalyzedYearDao callingPeakAnalyzedYearDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CallingPeakAnalyzedYear.class);

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
        pageList = callingPeakAnalyzedYearDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CallingPeakAnalyzedYear findByid(Integer id) {
        return callingPeakAnalyzedYearDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        callingPeakAnalyzedYearDao.delete(id);
    }

    @Override
    public void save(CallingPeakAnalyzedYear callingPeakAnalyzedYear) {
        callingPeakAnalyzedYearDao.save(callingPeakAnalyzedYear);
    }

    @Override
    public void saveOrUpd(CallingPeakAnalyzedYear callingPeakAnalyzedYear) {
        callingPeakAnalyzedYearDao.saveOrUpdate(callingPeakAnalyzedYear);
    }
}