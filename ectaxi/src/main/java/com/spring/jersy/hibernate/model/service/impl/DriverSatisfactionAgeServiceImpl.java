package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverSatisfactionAgeDao;
import com.spring.jersy.hibernate.model.entity.DriverSatisfactionAge;
import com.spring.jersy.hibernate.model.service.DriverSatisfactionAgeService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverSatisfactionAgeServiceImpl implements DriverSatisfactionAgeService {

    @Autowired
    private DriverSatisfactionAgeDao driverSatisfactionAgeDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverSatisfactionAge.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(companyname like '%" + key + "%' )"));
        }
        if (!S.isNull(begintime)) {

            dc.add(Restrictions.ge("satistime", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("satistime", begintime));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverSatisfactionAgeDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverSatisfactionAge findByid(Integer id) {
        return driverSatisfactionAgeDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverSatisfactionAgeDao.delete(id);
    }

    @Override
    public void save(DriverSatisfactionAge driverSatisfactionAge) {
        driverSatisfactionAgeDao.save(driverSatisfactionAge);
    }

    @Override
    public void saveOrUpd(DriverSatisfactionAge driverSatisfactionAge) {
        driverSatisfactionAgeDao.saveOrUpdate(driverSatisfactionAge);
    }
}
