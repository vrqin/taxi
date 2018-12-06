package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverComplaintsYearDao;
import com.spring.jersy.hibernate.model.entity.DriverComplaintsYear;
import com.spring.jersy.hibernate.model.service.DriverComplaintsYearService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverComplaintsYearServiceImpl implements DriverComplaintsYearService {

    @Autowired
    private DriverComplaintsYearDao driverComplaintsYearDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverComplaintsYear.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("( account like '%" + key + "%')"));
        }

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
        pageList = driverComplaintsYearDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverComplaintsYear findByid(Integer id) {
        return driverComplaintsYearDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverComplaintsYearDao.delete(id);
    }

    @Override
    public void save(DriverComplaintsYear driverComplaintsYear) {
        driverComplaintsYearDao.save(driverComplaintsYear);
    }

    @Override
    public void saveOrUpd(DriverComplaintsYear driverComplaintsYear) {
        driverComplaintsYearDao.saveOrUpdate(driverComplaintsYear);
    }
}