package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseCreditDistribuDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseCreditDistribu;
import com.spring.jersy.hibernate.model.service.EnterpriseCreditDistribuService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class EnterpriseCreditDistribuServiceImpl implements EnterpriseCreditDistribuService {

    @Autowired
    private EnterpriseCreditDistribuDao enterpriseCreditDistribuDao;

    @Override
    public List<EnterpriseCreditDistribu> findList(String sort, String order, String key, String begintime, String endtime) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseCreditDistribu.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or phone like '%" + key + "%'or kabnum like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("calltime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("calltime", end));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        return enterpriseCreditDistribuDao.findByDetachedCriteria(dc);
    }

    @Override
    public EnterpriseCreditDistribu findByid(Integer id) {
        return enterpriseCreditDistribuDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseCreditDistribuDao.delete(id);
    }

    @Override
    public void save(EnterpriseCreditDistribu enterpriseCreditDistribu) {
        enterpriseCreditDistribuDao.save(enterpriseCreditDistribu);
    }

    @Override
    public void saveOrUpd(EnterpriseCreditDistribu enterpriseCreditDistribu) {
        enterpriseCreditDistribuDao.saveOrUpdate(enterpriseCreditDistribu);
    }
}
