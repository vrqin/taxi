package com.spring.jersy.hibernate.model.service.impl;


import com.spring.jersy.hibernate.model.dao.SysSetDao;
import com.spring.jersy.hibernate.model.entity.SysSet;
import com.spring.jersy.hibernate.model.service.SysSetServer;
import com.spring.jersy.hibernate.publics.util.PageList;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/7/15.
 */
@Service
public class SysSetServerImpl implements SysSetServer {

    @Autowired
    private SysSetDao sysSetDao;

    @Override
    public PageList findPageList(int page, int size, String sort, String order, String key) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(SysSet.class);
        if ("asc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, size);
        pageList = sysSetDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public void save(SysSet sysSet) {
        sysSetDao.saveOrUpdate(sysSet);
    }
}
