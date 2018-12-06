package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseInformationAnalysisEconomiDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseInformationAnalysisEconomi;
import com.spring.jersy.hibernate.model.service.EnterpriseInformationAnalysisEconomiService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseInformationAnalysisEconomiServiceImpl implements EnterpriseInformationAnalysisEconomiService {

    @Autowired
    private EnterpriseInformationAnalysisEconomiDao enterpriseInformationAnalysisEconomiDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseInformationAnalysisEconomi.class);

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
        pageList = enterpriseInformationAnalysisEconomiDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseInformationAnalysisEconomi findByid(Integer id) {
        return enterpriseInformationAnalysisEconomiDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseInformationAnalysisEconomiDao.delete(id);
    }

    @Override
    public void save(EnterpriseInformationAnalysisEconomi enterpriseInformationAnalysisEconomi) {
        enterpriseInformationAnalysisEconomiDao.save(enterpriseInformationAnalysisEconomi);
    }

    @Override
    public void saveOrUpd(EnterpriseInformationAnalysisEconomi enterpriseInformationAnalysisEconomi) {
        enterpriseInformationAnalysisEconomiDao.saveOrUpdate(enterpriseInformationAnalysisEconomi);
    }
}
