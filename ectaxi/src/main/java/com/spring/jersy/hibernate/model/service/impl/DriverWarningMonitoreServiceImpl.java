package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverWarningMonitoreDao;
import com.spring.jersy.hibernate.model.entity.DriverWarningMonitore;
import com.spring.jersy.hibernate.model.service.DriverWarningMonitoreService;
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
public class DriverWarningMonitoreServiceImpl implements DriverWarningMonitoreService {

    @Autowired
    private DriverWarningMonitoreDao driverWarningMonitoreDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverWarningMonitore.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(enterprisename like '%" + key + "%' or account like '%" + key + "%'or evaluationversion like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("evaluationtime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("evaluationtime", end));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("evaluationLevel", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverWarningMonitoreDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverWarningMonitore findByid(Integer id) {
        return driverWarningMonitoreDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverWarningMonitoreDao.delete(id);
    }

    @Override
    public void save(DriverWarningMonitore driverWarningMonitore) {
        driverWarningMonitoreDao.save(driverWarningMonitore);
    }

    @Override
    public void saveOrUpd(DriverWarningMonitore driverWarningMonitore) {
        driverWarningMonitoreDao.saveOrUpdate(driverWarningMonitore);
    }
}
