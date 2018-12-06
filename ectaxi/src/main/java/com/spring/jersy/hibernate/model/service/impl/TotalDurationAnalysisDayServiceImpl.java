package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.TotalDurationAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.TotalDurationAnalysisDay;
import com.spring.jersy.hibernate.model.service.TotalDurationAnalysisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TotalDurationAnalysisDayServiceImpl implements TotalDurationAnalysisDayService {

    @Autowired
    private TotalDurationAnalysisDayDao totalDurationAnalysisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(TotalDurationAnalysisDay.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(company like '%" + key + "%' )"));
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
        pageList = totalDurationAnalysisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public TotalDurationAnalysisDay findByid(Integer id) {
        return totalDurationAnalysisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        totalDurationAnalysisDayDao.delete(id);
    }

    @Override
    public void save(TotalDurationAnalysisDay totalDurationAnalysisDay) {
        totalDurationAnalysisDayDao.save(totalDurationAnalysisDay);
    }

    @Override
    public void saveOrUpd(TotalDurationAnalysisDay totalDurationAnalysisDay) {
        totalDurationAnalysisDayDao.saveOrUpdate(totalDurationAnalysisDay);
    }
}
