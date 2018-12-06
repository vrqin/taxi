package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.PassengerCheckInformationDao;
import com.spring.jersy.hibernate.model.entity.PassengerCheckInformation;
import com.spring.jersy.hibernate.model.service.PassengerCheckInformationService;
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
public class PassengerCheckInformationServiceImpl implements PassengerCheckInformationService {

    @Autowired
    private PassengerCheckInformationDao passengerCheckInformationDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(PassengerCheckInformation.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  phone like '%" + key + "%'or name like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("regtime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("regtime", end));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = passengerCheckInformationDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PassengerCheckInformation findByid(Integer id) {
        return passengerCheckInformationDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        passengerCheckInformationDao.delete(id);
    }

    @Override
    public void save(PassengerCheckInformation passengerCheckInformation) {
        passengerCheckInformationDao.save(passengerCheckInformation);
    }

    @Override
    public void saveOrUpd(PassengerCheckInformation passengerCheckInformation) {
        passengerCheckInformationDao.saveOrUpdate(passengerCheckInformation);
    }
}
