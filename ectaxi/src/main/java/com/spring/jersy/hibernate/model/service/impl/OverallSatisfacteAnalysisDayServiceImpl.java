package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.OverallSatisfacteAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.OverallSatisfacteAnalysisDay;
import com.spring.jersy.hibernate.model.service.OverallSatisfacteAnalysisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OverallSatisfacteAnalysisDayServiceImpl implements OverallSatisfacteAnalysisDayService {

    @Autowired
    private OverallSatisfacteAnalysisDayDao overallSatisfacteAnalysisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(OverallSatisfacteAnalysisDay.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(companyname like '%" + key + "%' )"));
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
        pageList = overallSatisfacteAnalysisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public OverallSatisfacteAnalysisDay findByid(Integer id) {
        return overallSatisfacteAnalysisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        overallSatisfacteAnalysisDayDao.delete(id);
    }

    @Override
    public void save(OverallSatisfacteAnalysisDay overallSatisfacteAnalysisDay) {
        overallSatisfacteAnalysisDayDao.save(overallSatisfacteAnalysisDay);
    }

    @Override
    public void saveOrUpd(OverallSatisfacteAnalysisDay overallSatisfacteAnalysisDay) {
        overallSatisfacteAnalysisDayDao.saveOrUpdate(overallSatisfacteAnalysisDay);
    }
}
