package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverSerDetailsDao;
import com.spring.jersy.hibernate.model.entity.DriverSerDetails;
import com.spring.jersy.hibernate.model.service.DriverSerDetailsService;
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
public class DriverSerDetailsServiceImpl implements DriverSerDetailsService {

    @Autowired
    private DriverSerDetailsDao driverSerDetailsDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverSerDetails.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(account like '%" + key + "%' or kabnum like '%" + key + "%' or passphone like '%" + key + "%'  or passname like '%" + key + "%'  or ordernum like '%" + key + "%' )"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("calltime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("calltime", end));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("star", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverSerDetailsDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverSerDetails findByid(Integer id) {
        return driverSerDetailsDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverSerDetailsDao.delete(id);
    }

    @Override
    public void save(DriverSerDetails driverSerDetails) {
        driverSerDetailsDao.save(driverSerDetails);
    }

    @Override
    public void saveOrUpd(DriverSerDetails driverSerDetails) {
        driverSerDetailsDao.saveOrUpdate(driverSerDetails);
    }
}
