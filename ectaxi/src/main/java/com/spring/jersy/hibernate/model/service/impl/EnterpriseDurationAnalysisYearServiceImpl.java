package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseDurationAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseDurationAnalysisYear;
import com.spring.jersy.hibernate.model.service.EnterpriseDurationAnalysisYearService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseDurationAnalysisYearServiceImpl implements EnterpriseDurationAnalysisYearService {

    @Autowired
    private EnterpriseDurationAnalysisYearDao enterpriseDurationAnalysisYearDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseDurationAnalysisYear.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  companyname like '%" + key + "%')"));
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
        pageList = enterpriseDurationAnalysisYearDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseDurationAnalysisYear findByid(Integer id) {
        return enterpriseDurationAnalysisYearDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseDurationAnalysisYearDao.delete(id);
    }

    @Override
    public void save(EnterpriseDurationAnalysisYear enterpriseDurationAnalysisYear) {
        enterpriseDurationAnalysisYearDao.save(enterpriseDurationAnalysisYear);
    }

    @Override
    public void saveOrUpd(EnterpriseDurationAnalysisYear enterpriseDurationAnalysisYear) {
        enterpriseDurationAnalysisYearDao.saveOrUpdate(enterpriseDurationAnalysisYear);
    }
}