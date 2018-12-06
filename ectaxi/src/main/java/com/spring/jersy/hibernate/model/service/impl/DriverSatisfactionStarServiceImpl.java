package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverSatisfactionStarDao;
import com.spring.jersy.hibernate.model.entity.DriverSatisfactionStar;
import com.spring.jersy.hibernate.model.service.DriverSatisfactionStarService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverSatisfactionStarServiceImpl implements DriverSatisfactionStarService {

    @Autowired
    private DriverSatisfactionStarDao driverSatisfactionStarDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverSatisfactionStar.class);

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
        pageList = driverSatisfactionStarDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverSatisfactionStar findByid(Integer id) {
        return driverSatisfactionStarDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverSatisfactionStarDao.delete(id);
    }

    @Override
    public void save(DriverSatisfactionStar driverSatisfactionStar) {
        driverSatisfactionStarDao.save(driverSatisfactionStar);
    }

    @Override
    public void saveOrUpd(DriverSatisfactionStar driverSatisfactionStar) {
        driverSatisfactionStarDao.saveOrUpdate(driverSatisfactionStar);
    }
}
