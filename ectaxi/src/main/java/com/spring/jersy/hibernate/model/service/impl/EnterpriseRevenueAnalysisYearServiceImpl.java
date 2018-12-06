package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseRevenueAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseRevenueAnalysisYear;
import com.spring.jersy.hibernate.model.service.EnterpriseRevenueAnalysisYearService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseRevenueAnalysisYearServiceImpl implements EnterpriseRevenueAnalysisYearService {

    @Autowired
    private EnterpriseRevenueAnalysisYearDao enterpriseRevenueAnalysisYearDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseRevenueAnalysisYear.class);

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
        pageList = enterpriseRevenueAnalysisYearDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseRevenueAnalysisYear findByid(Integer id) {
        return enterpriseRevenueAnalysisYearDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseRevenueAnalysisYearDao.delete(id);
    }

    @Override
    public void save(EnterpriseRevenueAnalysisYear enterpriseRevenueAnalysisYear) {
        enterpriseRevenueAnalysisYearDao.save(enterpriseRevenueAnalysisYear);
    }

    @Override
    public void saveOrUpd(EnterpriseRevenueAnalysisYear enterpriseRevenueAnalysisYear) {
        enterpriseRevenueAnalysisYearDao.saveOrUpdate(enterpriseRevenueAnalysisYear);
    }
}
