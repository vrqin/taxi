package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.ClassSetDao;
import com.spring.jersy.hibernate.model.entity.ClassSet;
import com.spring.jersy.hibernate.model.service.ClassSetService;
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
public class ClassSetServiceImpl implements ClassSetService {

    @Autowired
    private ClassSetDao classSetDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(ClassSet.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  classname like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("createtime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("createtime", end));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = classSetDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public ClassSet findByid(Integer id) {
        return classSetDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        classSetDao.delete(id);
    }

    @Override
    public void save(ClassSet classSet) {
        classSetDao.save(classSet);
    }

    @Override
    public void saveOrUpd(ClassSet classSet) {
        classSetDao.saveOrUpdate(classSet);
    }
}
