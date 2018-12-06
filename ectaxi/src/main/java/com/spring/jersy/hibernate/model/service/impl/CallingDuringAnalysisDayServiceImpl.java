package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CallingDuringAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.CallingDuringAnalysisDay;
import com.spring.jersy.hibernate.model.service.CallingDuringAnalysisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CallingDuringAnalysisDayServiceImpl implements CallingDuringAnalysisDayService {

    @Autowired
    private CallingDuringAnalysisDayDao callingDuringAnalysisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CallingDuringAnalysisDay.class);

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
        pageList = callingDuringAnalysisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CallingDuringAnalysisDay findByid(Integer id) {
        return callingDuringAnalysisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        callingDuringAnalysisDayDao.delete(id);
    }

    @Override
    public void save(CallingDuringAnalysisDay callingDuringAnalysisDay) {
        callingDuringAnalysisDayDao.save(callingDuringAnalysisDay);
    }

    @Override
    public void saveOrUpd(CallingDuringAnalysisDay callingDuringAnalysisDay) {
        callingDuringAnalysisDayDao.saveOrUpdate(callingDuringAnalysisDay);
    }
}
