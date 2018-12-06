package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverSatisfactionWorktimeDao;
import com.spring.jersy.hibernate.model.entity.DriverSatisfactionWorktime;
import com.spring.jersy.hibernate.model.service.DriverSatisfactionWorktimeService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverSatisfactionWorktimeServiceImpl implements DriverSatisfactionWorktimeService {

    @Autowired
    private DriverSatisfactionWorktimeDao driverSatisfactionWorktimeDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverSatisfactionWorktime.class);

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
        pageList = driverSatisfactionWorktimeDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverSatisfactionWorktime findByid(Integer id) {
        return driverSatisfactionWorktimeDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverSatisfactionWorktimeDao.delete(id);
    }

    @Override
    public void save(DriverSatisfactionWorktime driverSatisfactionWorktime) {
        driverSatisfactionWorktimeDao.save(driverSatisfactionWorktime);
    }

    @Override
    public void saveOrUpd(DriverSatisfactionWorktime driverSatisfactionWorktime) {
        driverSatisfactionWorktimeDao.saveOrUpdate(driverSatisfactionWorktime);
    }
}
