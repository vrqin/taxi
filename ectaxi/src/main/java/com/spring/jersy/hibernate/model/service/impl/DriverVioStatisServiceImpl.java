package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverVioStatisDao;
import com.spring.jersy.hibernate.model.entity.DriverVioStatis;
import com.spring.jersy.hibernate.model.service.DriverVioStatisService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverVioStatisServiceImpl implements DriverVioStatisService {

    @Autowired
    private DriverVioStatisDao driverVioStatisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverVioStatis.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or arealine like '%" + key + "%')"));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverVioStatisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverVioStatis findByid(Integer id) {
        return driverVioStatisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverVioStatisDao.delete(id);
    }

    @Override
    public void save(DriverVioStatis driverVioStatis) {
        driverVioStatisDao.save(driverVioStatis);
    }

    @Override
    public void saveOrUpd(DriverVioStatis driverVioStatis) {
        driverVioStatisDao.saveOrUpdate(driverVioStatis);
    }
}
