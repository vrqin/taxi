package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.OverallSatisfacteAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.OverallSatisfacteAnalysisMonth;
import com.spring.jersy.hibernate.model.service.OverallSatisfacteAnalysisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OverallSatisfacteAnalysisMonthServiceImpl implements OverallSatisfacteAnalysisMonthService {

    @Autowired
    private OverallSatisfacteAnalysisMonthDao overallSatisfacteAnalysisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(OverallSatisfacteAnalysisMonth.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(companyname like '%" + key + "%' )"));
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
        pageList = overallSatisfacteAnalysisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public OverallSatisfacteAnalysisMonth findByid(Integer id) {
        return overallSatisfacteAnalysisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        overallSatisfacteAnalysisMonthDao.delete(id);
    }

    @Override
    public void save(OverallSatisfacteAnalysisMonth overallSatisfacteAnalysisMonth) {
        overallSatisfacteAnalysisMonthDao.save(overallSatisfacteAnalysisMonth);
    }

    @Override
    public void saveOrUpd(OverallSatisfacteAnalysisMonth overallSatisfacteAnalysisMonth) {
        overallSatisfacteAnalysisMonthDao.saveOrUpdate(overallSatisfacteAnalysisMonth);
    }
}
