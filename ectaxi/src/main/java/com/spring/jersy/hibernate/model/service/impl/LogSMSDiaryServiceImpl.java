package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.LogSMSDiaryDao;
import com.spring.jersy.hibernate.model.entity.LogSMSDiary;
import com.spring.jersy.hibernate.model.service.LogSMSDiaryService;
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

/**
 * Created by Administrator on 2016/9/12.
 */
@Service
public class LogSMSDiaryServiceImpl implements LogSMSDiaryService {

    @Autowired
    private LogSMSDiaryDao logSMSDiaryDao;

    @Override
    public List<LogSMSDiary> findList(String sort, String order, String key, String begintime, String endtime, Byte status, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(LogSMSDiary.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(phone like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("sendtime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("sendtime", end));
        }

        if (!S.isNull(status) && status != -1) {

            dc.add(Restrictions.eq("status", status));
        }
        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        return logSMSDiaryDao.findByDetachedCriteria(dc);
    }

    @Override
    public PageList findPageList(int page, int rows, String sort, String order, String key, String begintime, String endtime, Byte status, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(LogSMSDiary.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(phone like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("sendtime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("sendtime", end));
        }

        if (!S.isNull(status) && status != -1) {

            dc.add(Restrictions.eq("status", status));
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
        return logSMSDiaryDao.findPageList(pageList, dc);
    }

    @Override
    public LogSMSDiary findByid(Integer id) {
        return logSMSDiaryDao.get(id);
    }

    @Override
    public void save(LogSMSDiary logSMSDiary) {
        logSMSDiaryDao.save(logSMSDiary);
    }

    @Override
    public void saveOrUpd(LogSMSDiary logSMSDiary) {
        logSMSDiaryDao.saveOrUpdate(logSMSDiary);
    }
}
