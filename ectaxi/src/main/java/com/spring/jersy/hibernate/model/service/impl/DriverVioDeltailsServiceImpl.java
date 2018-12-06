package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverVioDeltailsDao;
import com.spring.jersy.hibernate.model.entity.DriverVioDeltails;
import com.spring.jersy.hibernate.model.service.DriverVioDeltailsService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/11.
 */
@Service
public class DriverVioDeltailsServiceImpl implements DriverVioDeltailsService {

    @Autowired
    private DriverVioDeltailsDao driverVioDeltailsDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverVioDeltails.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or kabnum like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("viotime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("viotime", end));
        }

        if (!S.isNull(type)) {
            dc.add(Restrictions.eq("type", type));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }

        PageList pageList = new PageList(page, rows);
        pageList = driverVioDeltailsDao.findPageList(pageList, dc);

        return pageList;
    }
}