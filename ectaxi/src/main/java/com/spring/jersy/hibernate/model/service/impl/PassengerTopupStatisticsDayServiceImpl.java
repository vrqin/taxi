package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.PassengerTopupStatisticsDayDao;
import com.spring.jersy.hibernate.model.entity.PassengerTopupStatisticsDay;
import com.spring.jersy.hibernate.model.service.PassengerTopupStatisticsDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PassengerTopupStatisticsDayServiceImpl implements PassengerTopupStatisticsDayService {

    @Autowired
    private PassengerTopupStatisticsDayDao passengerTopupStatisticsDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(PassengerTopupStatisticsDay.class);

        if (!S.isNull(begintime)) {
            dc.add(Restrictions.ge("date", begintime));
        }

        if (!S.isNull(endtime)) {
            dc.add(Restrictions.le("date", endtime));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = passengerTopupStatisticsDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PassengerTopupStatisticsDay findByid(Integer id) {
        return passengerTopupStatisticsDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        passengerTopupStatisticsDayDao.delete(id);
    }

    @Override
    public void save(PassengerTopupStatisticsDay passengerTopupStatisticsDay) {
        passengerTopupStatisticsDayDao.save(passengerTopupStatisticsDay);
    }

    @Override
    public void saveOrUpd(PassengerTopupStatisticsDay passengerTopupStatisticsDay) {
        passengerTopupStatisticsDayDao.saveOrUpdate(passengerTopupStatisticsDay);
    }
}
