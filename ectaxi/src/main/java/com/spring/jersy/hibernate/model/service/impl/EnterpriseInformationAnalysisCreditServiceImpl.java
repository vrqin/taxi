package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseInformationAnalysisCreditDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseInformationAnalysisCredit;
import com.spring.jersy.hibernate.model.service.EnterpriseInformationAnalysisCreditService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseInformationAnalysisCreditServiceImpl implements EnterpriseInformationAnalysisCreditService {

    @Autowired
    private EnterpriseInformationAnalysisCreditDao enterpriseInformationAnalysisCreditDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseInformationAnalysisCredit.class);


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
        pageList = enterpriseInformationAnalysisCreditDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseInformationAnalysisCredit findByid(Integer id) {
        return enterpriseInformationAnalysisCreditDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseInformationAnalysisCreditDao.delete(id);
    }

    @Override
    public void save(EnterpriseInformationAnalysisCredit enterpriseInformationAnalysisCredit) {
        enterpriseInformationAnalysisCreditDao.save(enterpriseInformationAnalysisCredit);
    }

    @Override
    public void saveOrUpd(EnterpriseInformationAnalysisCredit enterpriseInformationAnalysisCredit) {
        enterpriseInformationAnalysisCreditDao.saveOrUpdate(enterpriseInformationAnalysisCredit);
    }
}
