package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseRevenueAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseRevenueAnalysisMonth;
import com.spring.jersy.hibernate.model.service.EnterpriseRevenueAnalysisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseRevenueAnalysisMonthServiceImpl implements EnterpriseRevenueAnalysisMonthService {

    @Autowired
    private EnterpriseRevenueAnalysisMonthDao enterpriseRevenueAnalysisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseRevenueAnalysisMonth.class);

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
        pageList = enterpriseRevenueAnalysisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseRevenueAnalysisMonth findByid(Integer id) {
        return enterpriseRevenueAnalysisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseRevenueAnalysisMonthDao.delete(id);
    }

    @Override
    public void save(EnterpriseRevenueAnalysisMonth enterpriseRevenueAnalysisMonth) {
        enterpriseRevenueAnalysisMonthDao.save(enterpriseRevenueAnalysisMonth);
    }

    @Override
    public void saveOrUpd(EnterpriseRevenueAnalysisMonth enterpriseRevenueAnalysisMonth) {
        enterpriseRevenueAnalysisMonthDao.saveOrUpdate(enterpriseRevenueAnalysisMonth);
    }
}
