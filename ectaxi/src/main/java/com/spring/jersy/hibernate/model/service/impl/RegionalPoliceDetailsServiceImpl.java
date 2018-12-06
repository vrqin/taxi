package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.RegionalPoliceDetailsDao;
import com.spring.jersy.hibernate.model.entity.RegionalPoliceDetails;
import com.spring.jersy.hibernate.model.service.RegionalPoliceDetailsService;
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
public class RegionalPoliceDetailsServiceImpl implements RegionalPoliceDetailsService {

    @Autowired
    private RegionalPoliceDetailsDao regionalPoliceDetailsDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(RegionalPoliceDetails.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(kabnum like '%" + key + "%' or account like '%" + key + "%'or unit like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("creattime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("creattime", end));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("type", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = regionalPoliceDetailsDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public RegionalPoliceDetails findByid(Integer id) {
        return regionalPoliceDetailsDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        regionalPoliceDetailsDao.delete(id);
    }

    @Override
    public void save(RegionalPoliceDetails regionalPoliceDetails) {
        regionalPoliceDetailsDao.save(regionalPoliceDetails);
    }

    @Override
    public void saveOrUpd(RegionalPoliceDetails regionalPoliceDetails) {
        regionalPoliceDetailsDao.saveOrUpdate(regionalPoliceDetails);
    }
}
