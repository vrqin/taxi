package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.OverspeedAlarmDetailsDao;
import com.spring.jersy.hibernate.model.entity.OverspeedAlarmDetails;
import com.spring.jersy.hibernate.model.service.OverspeedAlarmDetailsService;
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
public class OverspeedAlarmDetailsServiceImpl implements OverspeedAlarmDetailsService {

    @Autowired
    private OverspeedAlarmDetailsDao overspeedAlarmDetailsDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(OverspeedAlarmDetails.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(kabnum like '%" + key + "%' or account like '%" + key + "%'or unit like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("creattime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("creattime", end));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = overspeedAlarmDetailsDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public OverspeedAlarmDetails findByid(Integer id) {
        return overspeedAlarmDetailsDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        overspeedAlarmDetailsDao.delete(id);
    }

    @Override
    public void save(OverspeedAlarmDetails overspeedAlarmDetails) {
        overspeedAlarmDetailsDao.save(overspeedAlarmDetails);
    }

    @Override
    public void saveOrUpd(OverspeedAlarmDetails overspeedAlarmDetails) {
        overspeedAlarmDetailsDao.saveOrUpdate(overspeedAlarmDetails);
    }
}
