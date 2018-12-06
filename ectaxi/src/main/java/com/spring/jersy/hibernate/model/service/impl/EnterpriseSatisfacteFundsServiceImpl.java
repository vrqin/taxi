package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseSatisfacteFundsDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteFunds;
import com.spring.jersy.hibernate.model.service.EnterpriseSatisfacteFundsService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseSatisfacteFundsServiceImpl implements EnterpriseSatisfacteFundsService {

    @Autowired
    private EnterpriseSatisfacteFundsDao enterpriseSatisfacteFundsDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseSatisfacteFunds.class);

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
        pageList = enterpriseSatisfacteFundsDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseSatisfacteFunds findByid(Integer id) {
        return enterpriseSatisfacteFundsDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseSatisfacteFundsDao.delete(id);
    }

    @Override
    public void save(EnterpriseSatisfacteFunds enterpriseSatisfacteFunds) {
        enterpriseSatisfacteFundsDao.save(enterpriseSatisfacteFunds);
    }

    @Override
    public void saveOrUpd(EnterpriseSatisfacteFunds enterpriseSatisfacteFunds) {
        enterpriseSatisfacteFundsDao.saveOrUpdate(enterpriseSatisfacteFunds);
    }
}
