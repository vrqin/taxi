package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseInformationAnalysisVehiclesDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseInformationAnalysisVehicles;
import com.spring.jersy.hibernate.model.service.EnterpriseInformationAnalysisVehiclesService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseInformationAnalysisVehiclesServiceImpl implements EnterpriseInformationAnalysisVehiclesService {

    @Autowired
    private EnterpriseInformationAnalysisVehiclesDao enterpriseInformationAnalysisVehiclesDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseInformationAnalysisVehicles.class);

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
        pageList = enterpriseInformationAnalysisVehiclesDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseInformationAnalysisVehicles findByid(Integer id) {
        return enterpriseInformationAnalysisVehiclesDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseInformationAnalysisVehiclesDao.delete(id);
    }

    @Override
    public void save(EnterpriseInformationAnalysisVehicles enterpriseInformationAnalysisVehicles) {
        enterpriseInformationAnalysisVehiclesDao.save(enterpriseInformationAnalysisVehicles);
    }

    @Override
    public void saveOrUpd(EnterpriseInformationAnalysisVehicles enterpriseInformationAnalysisVehicles) {
        enterpriseInformationAnalysisVehiclesDao.saveOrUpdate(enterpriseInformationAnalysisVehicles);
    }
}
