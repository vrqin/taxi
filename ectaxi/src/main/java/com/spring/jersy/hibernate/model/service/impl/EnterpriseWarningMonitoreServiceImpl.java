package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseWarningMonitoreDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseWarningMonitore;
import com.spring.jersy.hibernate.model.service.EnterpriseWarningMonitoreService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class EnterpriseWarningMonitoreServiceImpl implements EnterpriseWarningMonitoreService {

    @Autowired
    private EnterpriseWarningMonitoreDao enterpriseWarningMonitoreDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseWarningMonitore.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(enterprisename like '%" + key + "%' or evaluationversion like '%" + key + "%'or evaluationyears like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("evaluationtime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("evaluationtime", end));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("evaluationlevel", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = enterpriseWarningMonitoreDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseWarningMonitore findByid(Integer id) {
        return enterpriseWarningMonitoreDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseWarningMonitoreDao.delete(id);
    }

    @Override
    public void save(EnterpriseWarningMonitore enterpriseWarningMonitore) {
        enterpriseWarningMonitoreDao.save(enterpriseWarningMonitore);
    }

    @Override
    public void saveOrUpd(EnterpriseWarningMonitore enterpriseWarningMonitore) {
        enterpriseWarningMonitoreDao.saveOrUpdate(enterpriseWarningMonitore);
    }
}
