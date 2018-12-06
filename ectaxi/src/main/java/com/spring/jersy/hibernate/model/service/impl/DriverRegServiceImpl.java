package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverRegDao;
import com.spring.jersy.hibernate.model.entity.DriverReg;
import com.spring.jersy.hibernate.model.service.DriverRegService;
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
public class DriverRegServiceImpl implements DriverRegService {

    @Autowired
    private DriverRegDao driverRegDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverReg.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or phone like '%" + key + "%'or identity like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("applytime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("applytime", end));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("applystatus", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverRegDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverReg findByid(Integer id) {
        return driverRegDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverRegDao.delete(id);
    }

    @Override
    public void save(DriverReg driverReg) {
        driverRegDao.save(driverReg);
    }

    @Override
    public void saveOrUpd(DriverReg driverReg) {
        driverRegDao.saveOrUpdate(driverReg);
    }


}
