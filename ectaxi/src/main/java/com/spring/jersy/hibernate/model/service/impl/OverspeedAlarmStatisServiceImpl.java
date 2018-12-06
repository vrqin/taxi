package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.OverspeedAlarmStatisDao;
import com.spring.jersy.hibernate.model.entity.OverspeedAlarmStatis;
import com.spring.jersy.hibernate.model.service.OverspeedAlarmStatisService;
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
public class OverspeedAlarmStatisServiceImpl implements OverspeedAlarmStatisService {

    @Autowired
    private OverspeedAlarmStatisDao overspeedAlarmStatisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(OverspeedAlarmStatis.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(kabnum like '%" + key + "%' or driver like '%" + key + "%'or unit like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("time", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("time", end));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = overspeedAlarmStatisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public OverspeedAlarmStatis findByid(Integer id) {
        return overspeedAlarmStatisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        overspeedAlarmStatisDao.delete(id);
    }

    @Override
    public void save(OverspeedAlarmStatis overspeedAlarmStatis) {
        overspeedAlarmStatisDao.save(overspeedAlarmStatis);
    }

    @Override
    public void saveOrUpd(OverspeedAlarmStatis overspeedAlarmStatis) {
        overspeedAlarmStatisDao.saveOrUpdate(overspeedAlarmStatis);
    }
}
