package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.AuditExceptionDetailsDao;
import com.spring.jersy.hibernate.model.entity.AuditExceptionDetails;
import com.spring.jersy.hibernate.model.service.AuditExceptionDetailsService;
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
public class AuditExceptionDetailsServiceImpl implements AuditExceptionDetailsService {

    @Autowired
    private AuditExceptionDetailsDao auditExceptionDetailsDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(AuditExceptionDetails.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or company like '%" + key + "%'  or area like '%" + key + "%' or kabnum like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("starttime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("starttime", end));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("type", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = auditExceptionDetailsDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public AuditExceptionDetails findByid(Integer id) {
        return auditExceptionDetailsDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        auditExceptionDetailsDao.delete(id);
    }

    @Override
    public void save(AuditExceptionDetails auditExceptionDetails) {
        auditExceptionDetailsDao.save(auditExceptionDetails);
    }

    @Override
    public void saveOrUpd(AuditExceptionDetails auditExceptionDetails) {
        auditExceptionDetailsDao.saveOrUpdate(auditExceptionDetails);
    }
}
