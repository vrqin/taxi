package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseSatisfacteCartotalDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteCartotal;
import com.spring.jersy.hibernate.model.service.EnterpriseSatisfacteCartotalService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseSatisfacteCartotalServiceImpl implements EnterpriseSatisfacteCartotalService {

    @Autowired
    private EnterpriseSatisfacteCartotalDao enterpriseSatisfacteCartotalDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseSatisfacteCartotal.class);

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
        pageList = enterpriseSatisfacteCartotalDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseSatisfacteCartotal findByid(Integer id) {
        return enterpriseSatisfacteCartotalDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseSatisfacteCartotalDao.delete(id);
    }

    @Override
    public void save(EnterpriseSatisfacteCartotal enterpriseSatisfacteCartotal) {
        enterpriseSatisfacteCartotalDao.save(enterpriseSatisfacteCartotal);
    }

    @Override
    public void saveOrUpd(EnterpriseSatisfacteCartotal enterpriseSatisfacteCartotal) {
        enterpriseSatisfacteCartotalDao.saveOrUpdate(enterpriseSatisfacteCartotal);
    }
}
