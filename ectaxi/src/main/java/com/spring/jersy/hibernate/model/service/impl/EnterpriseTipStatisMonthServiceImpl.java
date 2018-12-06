package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseTipStatisMonthDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseTipStatisMonth;
import com.spring.jersy.hibernate.model.service.EnterpriseTipStatisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseTipStatisMonthServiceImpl implements EnterpriseTipStatisMonthService {

    @Autowired
    private EnterpriseTipStatisMonthDao enterpriseTipStatisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseTipStatisMonth.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  company like '%" + key + "%')"));
        }

        if (!S.isNull(begintime)) {
            dc.add(Restrictions.ge("month", begintime));
        }

        if (!S.isNull(endtime)) {
            dc.add(Restrictions.le("month", endtime));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = enterpriseTipStatisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseTipStatisMonth findByid(Integer id) {
        return enterpriseTipStatisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseTipStatisMonthDao.delete(id);
    }

    @Override
    public void save(EnterpriseTipStatisMonth enterpriseTipStatisMonth) {
        enterpriseTipStatisMonthDao.save(enterpriseTipStatisMonth);
    }

    @Override
    public void saveOrUpd(EnterpriseTipStatisMonth enterpriseTipStatisMonth) {
        enterpriseTipStatisMonthDao.saveOrUpdate(enterpriseTipStatisMonth);
    }
}
