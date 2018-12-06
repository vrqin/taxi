package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.NotifierPlusDao;
import com.spring.jersy.hibernate.model.entity.NotifierPlus;
import com.spring.jersy.hibernate.model.service.NotifierPlusService;
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
public class NotifierPlusServiceImpl implements NotifierPlusService {

    @Autowired
    private NotifierPlusDao notifierPlusDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(NotifierPlus.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(accountName like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("creattime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("creattime", end));
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
        pageList = notifierPlusDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public NotifierPlus findByid(Integer id) {
        return notifierPlusDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        notifierPlusDao.delete(id);
    }

    @Override
    public void save(NotifierPlus notifierPlus) {
        notifierPlusDao.save(notifierPlus);
    }

    @Override
    public void saveOrUpd(NotifierPlus notifierPlus) {
        notifierPlusDao.saveOrUpdate(notifierPlus);
    }
}
