package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.FreightDao;
import com.spring.jersy.hibernate.model.entity.Freight;
import com.spring.jersy.hibernate.model.service.FreightService;
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
public class FreightServiceImpl implements FreightService {

    @Autowired
    private FreightDao freightDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Freight.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(regional like '%" + key + "%' or description like '%" + key + "%'or kabnum like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("validitime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("validitime", end));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("state", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = freightDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public Freight findByid(Integer id) {
        return freightDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        freightDao.delete(id);
    }

    @Override
    public void save(Freight freight) {
        freightDao.save(freight);
    }

    @Override
    public void saveOrUpd(Freight freight) {
        freightDao.saveOrUpdate(freight);
    }
}
