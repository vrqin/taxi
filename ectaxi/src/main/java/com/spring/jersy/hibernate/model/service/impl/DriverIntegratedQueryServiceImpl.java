package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverIntegratedQueryDao;
import com.spring.jersy.hibernate.model.entity.DriverIntegratedQuery;
import com.spring.jersy.hibernate.model.service.DriverIntegratedQueryService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverIntegratedQueryServiceImpl implements DriverIntegratedQueryService {

    @Autowired
    private DriverIntegratedQueryDao driverIntegratedQueryDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverIntegratedQuery.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(account like '%" + key + "%' or clientid like '%" + key + "%'or totalincome like '%" + key + "%')"));
        }
        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverIntegratedQueryDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverIntegratedQuery findByid(Integer id) {
        return driverIntegratedQueryDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverIntegratedQueryDao.delete(id);
    }

    @Override
    public void save(DriverIntegratedQuery driverIntegratedQuery) {
        driverIntegratedQueryDao.save(driverIntegratedQuery);
    }

    @Override
    public void saveOrUpd(DriverIntegratedQuery driverIntegratedQuery) {
        driverIntegratedQueryDao.saveOrUpdate(driverIntegratedQuery);
    }
}
