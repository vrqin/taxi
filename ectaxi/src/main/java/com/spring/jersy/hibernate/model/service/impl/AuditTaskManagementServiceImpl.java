package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.AuditTaskManagementDao;
import com.spring.jersy.hibernate.model.entity.AuditTaskManagement;
import com.spring.jersy.hibernate.model.service.AuditTaskManagementService;
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
public class AuditTaskManagementServiceImpl implements AuditTaskManagementService {

    @Autowired
    private AuditTaskManagementDao auditTaskManagementDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(AuditTaskManagement.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(   taskname like '%" + key + "%')"));
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
            dc.add(Restrictions.eq("taskstatus", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = auditTaskManagementDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public AuditTaskManagement findByid(Integer id) {
        return auditTaskManagementDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        auditTaskManagementDao.delete(id);
    }

    @Override
    public void save(AuditTaskManagement auditTaskManagement) {
        auditTaskManagementDao.save(auditTaskManagement);
    }

    @Override
    public void saveOrUpd(AuditTaskManagement auditTaskManagement) {
        auditTaskManagementDao.saveOrUpdate(auditTaskManagement);
    }
}
