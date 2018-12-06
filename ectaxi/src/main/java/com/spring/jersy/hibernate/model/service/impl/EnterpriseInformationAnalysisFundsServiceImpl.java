package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseInformationAnalysisFundsDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseInformationAnalysisFunds;
import com.spring.jersy.hibernate.model.service.EnterpriseInformationAnalysisFundsService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseInformationAnalysisFundsServiceImpl implements EnterpriseInformationAnalysisFundsService {

    @Autowired
    private EnterpriseInformationAnalysisFundsDao enterpriseInformationAnalysisFundsDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseInformationAnalysisFunds.class);


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
        pageList = enterpriseInformationAnalysisFundsDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseInformationAnalysisFunds findByid(Integer id) {
        return enterpriseInformationAnalysisFundsDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseInformationAnalysisFundsDao.delete(id);
    }

    @Override
    public void save(EnterpriseInformationAnalysisFunds enterpriseInformationAnalysisFunds) {
        enterpriseInformationAnalysisFundsDao.save(enterpriseInformationAnalysisFunds);
    }

    @Override
    public void saveOrUpd(EnterpriseInformationAnalysisFunds enterpriseInformationAnalysisFunds) {
        enterpriseInformationAnalysisFundsDao.saveOrUpdate(enterpriseInformationAnalysisFunds);
    }
}
