package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CallingDefaultAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.CallingDefaultAnalysisDay;
import com.spring.jersy.hibernate.model.service.CallingDefaultAnalysisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CallingDefaultAnalysisDayServiceImpl implements CallingDefaultAnalysisDayService {

    @Autowired
    private CallingDefaultAnalysisDayDao callingDefaultAnalysisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CallingDefaultAnalysisDay.class);

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
        pageList = callingDefaultAnalysisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CallingDefaultAnalysisDay findByid(Integer id) {
        return callingDefaultAnalysisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        callingDefaultAnalysisDayDao.delete(id);
    }

    @Override
    public void save(CallingDefaultAnalysisDay callingDefaultAnalysisDay) {
        callingDefaultAnalysisDayDao.save(callingDefaultAnalysisDay);
    }

    @Override
    public void saveOrUpd(CallingDefaultAnalysisDay callingDefaultAnalysisDay) {
        callingDefaultAnalysisDayDao.saveOrUpdate(callingDefaultAnalysisDay);
    }
}
