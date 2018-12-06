package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverIncomeStatisDao;
import com.spring.jersy.hibernate.model.entity.DriverIncomeStatis;
import com.spring.jersy.hibernate.model.service.DriverIncomeStatisService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverIncomeStatisServiceImpl implements DriverIncomeStatisService {

    @Autowired
    private DriverIncomeStatisDao driverIncomeStatisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverIncomeStatis.class);


        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  company like '%" + key + "%')"));
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
        pageList = driverIncomeStatisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverIncomeStatis findByid(Integer id) {
        return driverIncomeStatisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverIncomeStatisDao.delete(id);
    }

    @Override
    public void save(DriverIncomeStatis driverIncomeStatis) {
        driverIncomeStatisDao.save(driverIncomeStatis);
    }

    @Override
    public void saveOrUpd(DriverIncomeStatis driverIncomeStatis) {
        driverIncomeStatisDao.saveOrUpdate(driverIncomeStatis);
    }
}
