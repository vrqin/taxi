package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.AuditTaskParameterDao;
import com.spring.jersy.hibernate.model.entity.AuditTaskParameter;
import com.spring.jersy.hibernate.model.service.AuditTaskParameterService;
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
public class AuditTaskParameterServiceImpl implements AuditTaskParameterService {

    @Autowired
    private AuditTaskParameterDao auditTaskParameterDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(AuditTaskParameter.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  auditarea like '%" + key + "%' or tasker like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("starttime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("starttime", end));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = auditTaskParameterDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public AuditTaskParameter findByid(Integer id) {
        return auditTaskParameterDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        auditTaskParameterDao.delete(id);
    }

    @Override
    public void save(AuditTaskParameter auditTaskParameter) {
        auditTaskParameterDao.save(auditTaskParameter);
    }

    @Override
    public void saveOrUpd(AuditTaskParameter auditTaskParameter) {
        auditTaskParameterDao.saveOrUpdate(auditTaskParameter);
    }
}
