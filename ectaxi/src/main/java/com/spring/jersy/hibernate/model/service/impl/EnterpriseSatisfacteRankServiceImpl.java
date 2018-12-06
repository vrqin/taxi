package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseSatisfacteRankDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteRank;
import com.spring.jersy.hibernate.model.service.EnterpriseSatisfacteRankService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseSatisfacteRankServiceImpl implements EnterpriseSatisfacteRankService {

    @Autowired
    private EnterpriseSatisfacteRankDao enterpriseSatisfacteRankDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseSatisfacteRank.class);

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
        pageList = enterpriseSatisfacteRankDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseSatisfacteRank findByid(Integer id) {
        return enterpriseSatisfacteRankDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseSatisfacteRankDao.delete(id);
    }

    @Override
    public void save(EnterpriseSatisfacteRank enterpriseSatisfacteRank) {
        enterpriseSatisfacteRankDao.save(enterpriseSatisfacteRank);
    }

    @Override
    public void saveOrUpd(EnterpriseSatisfacteRank enterpriseSatisfacteRank) {
        enterpriseSatisfacteRankDao.saveOrUpdate(enterpriseSatisfacteRank);
    }
}
