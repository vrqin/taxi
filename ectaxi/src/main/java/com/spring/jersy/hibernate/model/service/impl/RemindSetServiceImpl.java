package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.RemindSetDao;
import com.spring.jersy.hibernate.model.entity.RemindSet;
import com.spring.jersy.hibernate.model.service.RemindSetService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/9.
 */
@Service
public class RemindSetServiceImpl implements RemindSetService {

    @Autowired
    private RemindSetDao remindSetDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, Integer type, Integer extypes, Integer enable, Integer clientid) throws Exception {

        DetachedCriteria dc = DetachedCriteria.forClass(RemindSet.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(company like '%" + key + "%')"));
        }
        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("status", type));
        }
        if (extypes > (-1)) {
            dc.add(Restrictions.eq("extypes", extypes));
        }

        if (extypes > (-1)) {
            dc.add(Restrictions.eq("enable", enable));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = remindSetDao.findPageList(pageList, dc);

        return pageList;
    }

    @Override
    public RemindSet findByid(Integer id) {
        return remindSetDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        remindSetDao.delete(id);
    }

    @Override
    public void save(RemindSet remindSet) {
        remindSetDao.save(remindSet);
    }

    @Override
    public void saveOrUpd(RemindSet remindSet) {
        remindSetDao.saveOrUpdate(remindSet);
    }
}
