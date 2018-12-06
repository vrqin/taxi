package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.OperatDetailsDao;
import com.spring.jersy.hibernate.model.entity.OperatDetails;
import com.spring.jersy.hibernate.model.service.OperatDetailsService;
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
public class OperatDetailsServiceImpl implements OperatDetailsService {

    @Autowired
    private OperatDetailsDao operatDetailsDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(OperatDetails.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(account like '%" + key + "%' or kabnum like '%" + key + "%' or enterprise like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("getontime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("getontime", end));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = operatDetailsDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public OperatDetails findByid(Integer id) {
        return operatDetailsDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        operatDetailsDao.delete(id);
    }

    @Override
    public void save(OperatDetails operatDetails) {
        operatDetailsDao.save(operatDetails);
    }

    @Override
    public void saveOrUpd(OperatDetails operatDetails) {
        operatDetailsDao.saveOrUpdate(operatDetails);
    }
}
