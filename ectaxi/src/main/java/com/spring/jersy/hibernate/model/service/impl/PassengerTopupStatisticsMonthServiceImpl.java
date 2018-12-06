package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.PassengerTopupStatisticsMonthDao;
import com.spring.jersy.hibernate.model.entity.PassengerTopupStatisticsMonth;
import com.spring.jersy.hibernate.model.service.PassengerTopupStatisticsMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PassengerTopupStatisticsMonthServiceImpl implements PassengerTopupStatisticsMonthService {

    @Autowired
    private PassengerTopupStatisticsMonthDao passengerTopupStatisticsMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(PassengerTopupStatisticsMonth.class);


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
        pageList = passengerTopupStatisticsMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PassengerTopupStatisticsMonth findByid(Integer id) {
        return passengerTopupStatisticsMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        passengerTopupStatisticsMonthDao.delete(id);
    }

    @Override
    public void save(PassengerTopupStatisticsMonth passengerTopupStatisticsMonth) {
        passengerTopupStatisticsMonthDao.save(passengerTopupStatisticsMonth);
    }

    @Override
    public void saveOrUpd(PassengerTopupStatisticsMonth passengerTopupStatisticsMonth) {
        passengerTopupStatisticsMonthDao.saveOrUpdate(passengerTopupStatisticsMonth);
    }
}
