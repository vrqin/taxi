package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.NotifierHistoryDao;
import com.spring.jersy.hibernate.model.entity.NotifierPlusHistory;
import com.spring.jersy.hibernate.model.service.NotifierHistoryService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class NotifierHistoryServiceImpl implements NotifierHistoryService {

    @Autowired
    private NotifierHistoryDao notifierHistoryDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, Integer notifierid, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(NotifierPlusHistory.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%')"));
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

        if (type > 0) {
            dc.add(Restrictions.eq("status", type));
        }
        if (!S.isNull(notifierid)) {
            dc.add(Restrictions.eq("notifierid", notifierid));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = notifierHistoryDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public NotifierPlusHistory findByid(Integer id) {
        return notifierHistoryDao.get(id);
    }

    @Override
    public List<NotifierPlusHistory> findBynodtfierid(Integer id) {
        DetachedCriteria dc = DetachedCriteria.forClass(NotifierPlusHistory.class);

        if (!S.isNull(id)) {
            dc.add(Restrictions.eq("notifierid", id));
        }

        return notifierHistoryDao.findByDetachedCriteria(dc);
    }

    @Override
    public void delete(Integer id) {
        notifierHistoryDao.delete(id);
    }

    @Override
    public void deletebynodtfierid(Integer id) {
        String sql = "DELETE FROM `tab_notifier_history` WHERE notifierid =" + id;
        notifierHistoryDao.updateSql(sql);
    }

    @Override
    public void save(NotifierPlusHistory notifierHistory) {
        notifierHistoryDao.save(notifierHistory);
    }

    @Override
    public void saveOrUpd(NotifierPlusHistory notifierHistory) {
        notifierHistoryDao.saveOrUpdate(notifierHistory);
    }
}
