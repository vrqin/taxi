package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverSatisfactionRankingsDao;
import com.spring.jersy.hibernate.model.entity.DriverSatisfactionRankings;
import com.spring.jersy.hibernate.model.service.DriverSatisfactionRankingsService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverSatisfactionRankingsServiceImpl implements DriverSatisfactionRankingsService {

    @Autowired
    private DriverSatisfactionRankingsDao driverSatisfactionRankingsDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverSatisfactionRankings.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(account like '%" + key + "%' )"));
        }
        if (!S.isNull(begintime)) {
            dc.add(Restrictions.ge("satistime", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("satistime", endtime));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverSatisfactionRankingsDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverSatisfactionRankings findByid(Integer id) {
        return driverSatisfactionRankingsDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverSatisfactionRankingsDao.delete(id);
    }

    @Override
    public void save(DriverSatisfactionRankings driverSatisfactionRankings) {
        driverSatisfactionRankingsDao.save(driverSatisfactionRankings);
    }

    @Override
    public void saveOrUpd(DriverSatisfactionRankings driverSatisfactionRankings) {
        driverSatisfactionRankingsDao.saveOrUpdate(driverSatisfactionRankings);
    }
}
