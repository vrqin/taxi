package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.TerminalDao;
import com.spring.jersy.hibernate.model.entity.Terminal;
import com.spring.jersy.hibernate.model.service.TerminalService;
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
public class TerminalServiceImpl implements TerminalService {

    @Autowired
    private TerminalDao terminalDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Terminal.class);

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

        if (!S.isNull(type)) {
            dc.add(Restrictions.eq("type", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = terminalDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public Terminal findByid(Integer id) {
        return terminalDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        terminalDao.delete(id);
    }

    @Override
    public void save(Terminal terminal) {
        terminalDao.save(terminal);
    }

    @Override
    public void saveOrUpd(Terminal terminal) {
        terminalDao.saveOrUpdate(terminal);
    }
}
