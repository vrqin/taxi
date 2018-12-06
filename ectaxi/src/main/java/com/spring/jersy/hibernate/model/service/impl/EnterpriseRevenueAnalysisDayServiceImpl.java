package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseRevenueAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseRevenueAnalysisDay;
import com.spring.jersy.hibernate.model.service.EnterpriseRevenueAnalysisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseRevenueAnalysisDayServiceImpl implements EnterpriseRevenueAnalysisDayService {

    @Autowired
    private EnterpriseRevenueAnalysisDayDao enterpriseRevenueAnalysisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseRevenueAnalysisDay.class);


        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  companyname like '%" + key + "%')"));
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
        pageList = enterpriseRevenueAnalysisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseRevenueAnalysisDay findByid(Integer id) {
        return enterpriseRevenueAnalysisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseRevenueAnalysisDayDao.delete(id);
    }

    @Override
    public void save(EnterpriseRevenueAnalysisDay enterpriseRevenueAnalysisDay) {
        enterpriseRevenueAnalysisDayDao.save(enterpriseRevenueAnalysisDay);
    }

    @Override
    public void saveOrUpd(EnterpriseRevenueAnalysisDay enterpriseRevenueAnalysisDay) {
        enterpriseRevenueAnalysisDayDao.saveOrUpdate(enterpriseRevenueAnalysisDay);
    }
}
