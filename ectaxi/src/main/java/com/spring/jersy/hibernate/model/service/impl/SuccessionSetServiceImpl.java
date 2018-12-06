package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.SuccessionSetDao;
import com.spring.jersy.hibernate.model.entity.SuccessionSet;
import com.spring.jersy.hibernate.model.service.SuccessionSetService;
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
public class SuccessionSetServiceImpl implements SuccessionSetService {

    @Autowired
    private SuccessionSetDao successionSetDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(SuccessionSet.class);


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
        pageList = successionSetDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public SuccessionSet findByid(Integer id) {
        return successionSetDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        successionSetDao.delete(id);
    }

    @Override
    public void save(SuccessionSet successionSet) {
        successionSetDao.save(successionSet);
    }

    @Override
    public void saveOrUpd(SuccessionSet successionSet) {
        successionSetDao.saveOrUpdate(successionSet);
    }
}
