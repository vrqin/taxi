package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.PassengerTopupDetailDao;
import com.spring.jersy.hibernate.model.entity.PassengerTopupDetail;
import com.spring.jersy.hibernate.model.service.PassengerTopupDetailService;
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
public class PassengerTopupDetailServiceImpl implements PassengerTopupDetailService {

    @Autowired
    private PassengerTopupDetailDao passengerTopupDetailDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(PassengerTopupDetail.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(phone like '%" + key + "%' or name like '%" + key + "%'or money like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("topuptime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("topuptime", end));
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
        pageList = passengerTopupDetailDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PassengerTopupDetail findByid(Integer id) {
        return passengerTopupDetailDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        passengerTopupDetailDao.delete(id);
    }

    @Override
    public void save(PassengerTopupDetail passengerTopupDetail) {
        passengerTopupDetailDao.save(passengerTopupDetail);
    }

    @Override
    public void saveOrUpd(PassengerTopupDetail passengerTopupDetail) {
        passengerTopupDetailDao.saveOrUpdate(passengerTopupDetail);
    }
}
