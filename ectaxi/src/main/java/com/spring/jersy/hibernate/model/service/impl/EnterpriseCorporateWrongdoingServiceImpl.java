package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseCorporateWrongdoingDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseCorporateWrongdoing;
import com.spring.jersy.hibernate.model.service.EnterpriseCorporateWrongdoingService;
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
public class EnterpriseCorporateWrongdoingServiceImpl implements EnterpriseCorporateWrongdoingService {

    @Autowired
    private EnterpriseCorporateWrongdoingDao enterpriseCorporateWrongdoingDao;

    @Override
    public List<EnterpriseCorporateWrongdoing> findList(String sort, String order, String key, String begintime, String endtime) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseCorporateWrongdoing.class);

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
        return enterpriseCorporateWrongdoingDao.findByDetachedCriteria(dc);
    }

    @Override
    public EnterpriseCorporateWrongdoing findByid(Integer id) {
        return enterpriseCorporateWrongdoingDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseCorporateWrongdoingDao.delete(id);
    }

    @Override
    public void save(EnterpriseCorporateWrongdoing enterpriseCorporateWrongdoing) {
        enterpriseCorporateWrongdoingDao.save(enterpriseCorporateWrongdoing);
    }

    @Override
    public void saveOrUpd(EnterpriseCorporateWrongdoing enterpriseCorporateWrongdoing) {
        enterpriseCorporateWrongdoingDao.saveOrUpdate(enterpriseCorporateWrongdoing);
    }
}
