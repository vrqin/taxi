package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.TotalDurationAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.TotalDurationAnalysisMonth;
import com.spring.jersy.hibernate.model.service.TotalDurationAnalysisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TotalDurationAnalysisMonthServiceImpl implements TotalDurationAnalysisMonthService {

    @Autowired
    private TotalDurationAnalysisMonthDao totalDurationAnalysisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(TotalDurationAnalysisMonth.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(company like '%" + key + "%' )"));
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
        pageList = totalDurationAnalysisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public TotalDurationAnalysisMonth findByid(Integer id) {
        return totalDurationAnalysisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        totalDurationAnalysisMonthDao.delete(id);
    }

    @Override
    public void save(TotalDurationAnalysisMonth totalDurationAnalysisMonth) {
        totalDurationAnalysisMonthDao.save(totalDurationAnalysisMonth);
    }

    @Override
    public void saveOrUpd(TotalDurationAnalysisMonth totalDurationAnalysisMonth) {
        totalDurationAnalysisMonthDao.saveOrUpdate(totalDurationAnalysisMonth);
    }
}
