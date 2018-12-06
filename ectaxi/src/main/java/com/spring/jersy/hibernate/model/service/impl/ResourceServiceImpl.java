package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.ResourceDao;
import com.spring.jersy.hibernate.model.entity.Resource;
import com.spring.jersy.hibernate.model.service.ResourceService;
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
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Resource.class);

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
        pageList = resourceDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PageList findListByorder(int page, int rows, String sort, String order) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Resource.class);

        if ("asc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = resourceDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public Resource findByid(Integer id) {
        return resourceDao.get(id);
    }

    @Override
    public List<Resource> findListByPid(Integer pid, Integer ppid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Resource.class);
        if (!S.isNull(pid)) {
            dc.add(Restrictions.eq("pid", pid));
        }
        if (!S.isNull(ppid)) {
            dc.add(Restrictions.eq("ppid", ppid));
        }
        dc.addOrder(Order.asc("id"));
        return resourceDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<Resource> findListByid(Integer pid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Resource.class);
        if (!S.isNull(pid)) {
            dc.add(Restrictions.eq("pid", pid));
        }

        dc.addOrder(Order.asc("id"));
        return resourceDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<Resource> findListByPpid(Integer ppid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Resource.class);
        if (!S.isNull(ppid)) {
            dc.add(Restrictions.eq("ppid", ppid));
        }
        dc.addOrder(Order.asc("id"));
        return resourceDao.findByDetachedCriteria(dc);
    }

    @Override
    public void delete(Integer id) {
        resourceDao.delete(id);
    }

    @Override
    public void save(Resource resource) {
        resourceDao.save(resource);
    }

    @Override
    public void saveOrUpd(Resource resource) {
        resourceDao.saveOrUpdate(resource);
    }
}
