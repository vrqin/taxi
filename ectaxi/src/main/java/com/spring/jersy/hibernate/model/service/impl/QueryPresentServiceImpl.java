package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.QueryPresentDao;
import com.spring.jersy.hibernate.model.entity.QueryPresent;
import com.spring.jersy.hibernate.model.service.QueryPresentService;
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
public class QueryPresentServiceImpl implements QueryPresentService {

    @Autowired
    private QueryPresentDao queryPresentDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(QueryPresent.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(phone like '%" + key + "%' or account like '%" + key + "%' or seniority like '%" + key + "%'  or kabnum like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("geton", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("geton", end));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("flag", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = queryPresentDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public QueryPresent findByid(Integer id) {
        return queryPresentDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        queryPresentDao.delete(id);
    }

    @Override
    public void save(QueryPresent queryPresent) {
        queryPresentDao.save(queryPresent);
    }

    @Override
    public void saveOrUpd(QueryPresent queryPresent) {
        queryPresentDao.saveOrUpdate(queryPresent);
    }
}
