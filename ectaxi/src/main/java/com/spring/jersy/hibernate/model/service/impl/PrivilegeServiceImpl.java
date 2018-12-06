package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.PrivilegeDao;
import com.spring.jersy.hibernate.model.entity.Privilege;
import com.spring.jersy.hibernate.model.service.PrivilegeService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private PrivilegeDao privilegeDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Privilege.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("( privilegename like '%" + key + "%')"));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = privilegeDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public Privilege findByid(Integer id) {
        return privilegeDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        privilegeDao.delete(id);
    }

    @Override
    public void save(Privilege privilege) {
        privilegeDao.save(privilege);
    }

    @Override
    public void saveOrUpd(Privilege privilege) {
        privilegeDao.saveOrUpdate(privilege);
    }

    @Override
    public List<Privilege> findList() {
        DetachedCriteria dc = DetachedCriteria.forClass(Privilege.class);
        dc.addOrder(Order.asc("id"));
        return privilegeDao.findByDetachedCriteria(dc);
    }
}
