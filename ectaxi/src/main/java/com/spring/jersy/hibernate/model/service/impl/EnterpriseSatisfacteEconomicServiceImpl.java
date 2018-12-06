package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseSatisfacteEconomicDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteEconomic;
import com.spring.jersy.hibernate.model.service.EnterpriseSatisfacteEconomicService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseSatisfacteEconomicServiceImpl implements EnterpriseSatisfacteEconomicService {

    @Autowired
    private EnterpriseSatisfacteEconomicDao enterpriseSatisfacteEconomicDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseSatisfacteEconomic.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(companyname like '%" + key + "%' )"));
        }
        if (!S.isNull(begintime)) {
            dc.add(Restrictions.ge("satistime", begintime));
        }

        if (!S.isNull(endtime)) {
            dc.add(Restrictions.le("satistime", endtime));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = enterpriseSatisfacteEconomicDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseSatisfacteEconomic findByid(Integer id) {
        return enterpriseSatisfacteEconomicDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseSatisfacteEconomicDao.delete(id);
    }

    @Override
    public void save(EnterpriseSatisfacteEconomic enterpriseSatisfacteEconomic) {
        enterpriseSatisfacteEconomicDao.save(enterpriseSatisfacteEconomic);
    }

    @Override
    public void saveOrUpd(EnterpriseSatisfacteEconomic enterpriseSatisfacteEconomic) {
        enterpriseSatisfacteEconomicDao.saveOrUpdate(enterpriseSatisfacteEconomic);
    }
}
