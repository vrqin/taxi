package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CallingPeakAnalyzedDayDao;
import com.spring.jersy.hibernate.model.entity.CallingPeakAnalyzedDay;
import com.spring.jersy.hibernate.model.service.CallingPeakAnalyzedDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CallingPeakAnalyzedDayServiceImpl implements CallingPeakAnalyzedDayService {

    @Autowired
    private CallingPeakAnalyzedDayDao callingPeakAnalyzedDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CallingPeakAnalyzedDay.class);

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
        pageList = callingPeakAnalyzedDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CallingPeakAnalyzedDay findByid(Integer id) {
        return callingPeakAnalyzedDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        callingPeakAnalyzedDayDao.delete(id);
    }

    @Override
    public void save(CallingPeakAnalyzedDay callingPeakAnalyzedDay) {
        callingPeakAnalyzedDayDao.save(callingPeakAnalyzedDay);
    }

    @Override
    public void saveOrUpd(CallingPeakAnalyzedDay callingPeakAnalyzedDay) {
        callingPeakAnalyzedDayDao.saveOrUpdate(callingPeakAnalyzedDay);
    }
}
