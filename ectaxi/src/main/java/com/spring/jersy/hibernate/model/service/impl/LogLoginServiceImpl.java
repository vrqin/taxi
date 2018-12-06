package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.LogLoginDao;
import com.spring.jersy.hibernate.model.entity.LogLogin;
import com.spring.jersy.hibernate.model.service.LogLoginService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/12.
 */
@Service
public class LogLoginServiceImpl implements LogLoginService {

    @Autowired
    private LogLoginDao logLoginDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer type, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(LogLogin.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(account like '%" + key + "%' or name like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("operattime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("operattime", end));
        }
        if (!S.isNull(type)) {
            dc.add(Restrictions.eq("type", type));
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
        pageList = logLoginDao.findPageList(pageList, dc);

        return pageList;
    }

    @Override
    public LogLogin findByid(Integer id) {
        return logLoginDao.get(id);
    }

    @Override
    public void save(LogLogin logLogin) {
        logLoginDao.save(logLogin);
    }

    @Override
    public void saveOrUpd(LogLogin logLogin) {
        logLoginDao.saveOrUpdate(logLogin);
    }
}
