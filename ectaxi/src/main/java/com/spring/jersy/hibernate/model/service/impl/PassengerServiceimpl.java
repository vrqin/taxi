package com.spring.jersy.hibernate.model.service.impl;


import com.spring.jersy.hibernate.model.dao.PassengerDao;
import com.spring.jersy.hibernate.model.entity.Passenger;
import com.spring.jersy.hibernate.model.service.PassengerService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/4.
 */
@Service
public class PassengerServiceimpl implements PassengerService {

    @Autowired
    private PassengerDao passengerDao;

    @Override
    public Passenger findByid(String opruserid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Passenger.class);
        dc.add(Restrictions.eq("opruser", opruserid));
        return passengerDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public Passenger findByPass(String opruserid, String pws) {
        DetachedCriteria dc = DetachedCriteria.forClass(Passenger.class);
        dc.add(Restrictions.eq("opruser", opruserid));
        dc.add(Restrictions.eq("password", pws));
        return passengerDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public void delete(String opruserid) {
        String sql = "DELETE FROM tab_phoneuser WHERE opruser='" + opruserid + "'";
        passengerDao.updateSql(sql);
    }

    @Override
    public void save(Passenger passenger) {
        passengerDao.save(passenger);
    }


    @Override
    public void saveOrUpd(Passenger passenger) {
        passengerDao.saveOrUpdate(passenger);
    }

    @Override
    public PageList findPageList(int page, int rows, String sort, String order, String key, Integer type, String begintime, String endtime) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Passenger.class);
        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or mobile like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("createdate", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("createdate", end));
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
        pageList = passengerDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public List<Passenger> findAllList(String begintime, String endtime) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Passenger.class);
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("createdate", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("createdate", end));
        }
        dc.add(Restrictions.eq("type", 0));
        dc.addOrder(Order.desc("createdate"));

        return passengerDao.findByDetachedCriteria(dc);
    }


}
