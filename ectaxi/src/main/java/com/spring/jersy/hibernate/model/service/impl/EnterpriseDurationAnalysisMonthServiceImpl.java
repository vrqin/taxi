package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseDurationAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseDurationAnalysisMonth;
import com.spring.jersy.hibernate.model.service.EnterpriseDurationAnalysisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseDurationAnalysisMonthServiceImpl implements EnterpriseDurationAnalysisMonthService {

    @Autowired
    private EnterpriseDurationAnalysisMonthDao enterpriseDurationAnalysisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseDurationAnalysisMonth.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  companyname like '%" + key + "%')"));
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
        pageList = enterpriseDurationAnalysisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseDurationAnalysisMonth findByid(Integer id) {
        return enterpriseDurationAnalysisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseDurationAnalysisMonthDao.delete(id);
    }

    @Override
    public void save(EnterpriseDurationAnalysisMonth enterpriseDurationAnalysisMonth) {
        enterpriseDurationAnalysisMonthDao.save(enterpriseDurationAnalysisMonth);
    }

    @Override
    public void saveOrUpd(EnterpriseDurationAnalysisMonth enterpriseDurationAnalysisMonth) {
        enterpriseDurationAnalysisMonthDao.saveOrUpdate(enterpriseDurationAnalysisMonth);
    }
}
