package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverSerStatisDao;
import com.spring.jersy.hibernate.model.entity.DriverSerStatis;
import com.spring.jersy.hibernate.model.service.DriverSerStatisService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverSerStatisServiceImpl implements DriverSerStatisService {

    @Autowired
    private DriverSerStatisDao driverSerStatisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverSerStatis.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(account like '%" + key + "%' )"));
        }

        if (type > 0) {
            dc.add(Restrictions.eq("clientid", type));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverSerStatisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverSerStatis findByid(Integer id) {
        return driverSerStatisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverSerStatisDao.delete(id);
    }

    @Override
    public void save(DriverSerStatis driverSerStatis) {
        driverSerStatisDao.save(driverSerStatis);
    }

    @Override
    public void saveOrUpd(DriverSerStatis driverSerStatis) {
        driverSerStatisDao.saveOrUpdate(driverSerStatis);
    }
}
