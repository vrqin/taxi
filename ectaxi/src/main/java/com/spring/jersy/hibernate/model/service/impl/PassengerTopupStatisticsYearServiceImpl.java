package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.PassengerTopupStatisticsYearDao;
import com.spring.jersy.hibernate.model.entity.PassengerTopupStatisticsYear;
import com.spring.jersy.hibernate.model.service.PassengerTopupStatisticsYearService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PassengerTopupStatisticsYearServiceImpl implements PassengerTopupStatisticsYearService {

    @Autowired
    private PassengerTopupStatisticsYearDao passengerTopupStatisticsYearDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(PassengerTopupStatisticsYear.class);

        if (!S.isNull(begintime)) {

            dc.add(Restrictions.ge("annual", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("annual", endtime));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = passengerTopupStatisticsYearDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PassengerTopupStatisticsYear findByid(Integer id) {
        return passengerTopupStatisticsYearDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        passengerTopupStatisticsYearDao.delete(id);
    }

    @Override
    public void save(PassengerTopupStatisticsYear passengerTopupStatisticsYear) {
        passengerTopupStatisticsYearDao.save(passengerTopupStatisticsYear);
    }

    @Override
    public void saveOrUpd(PassengerTopupStatisticsYear passengerTopupStatisticsYear) {
        passengerTopupStatisticsYearDao.saveOrUpdate(passengerTopupStatisticsYear);
    }
}
