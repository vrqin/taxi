package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.TotalDurationAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.TotalDurationAnalysisYear;
import com.spring.jersy.hibernate.model.service.TotalDurationAnalysisYearService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TotalDurationAnalysisYearServiceImpl implements TotalDurationAnalysisYearService {

    @Autowired
    private TotalDurationAnalysisYearDao totalDurationAnalysisYearDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(TotalDurationAnalysisYear.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(company like '%" + key + "%' )"));
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
        pageList = totalDurationAnalysisYearDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public TotalDurationAnalysisYear findByid(Integer id) {
        return totalDurationAnalysisYearDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        totalDurationAnalysisYearDao.delete(id);
    }

    @Override
    public void save(TotalDurationAnalysisYear totalDurationAnalysisYear) {
        totalDurationAnalysisYearDao.save(totalDurationAnalysisYear);
    }

    @Override
    public void saveOrUpd(TotalDurationAnalysisYear totalDurationAnalysisYear) {
        totalDurationAnalysisYearDao.saveOrUpdate(totalDurationAnalysisYear);
    }
}
