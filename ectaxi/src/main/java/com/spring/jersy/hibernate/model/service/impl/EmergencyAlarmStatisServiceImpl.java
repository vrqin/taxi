package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EmergencyAlarmStatisDao;
import com.spring.jersy.hibernate.model.entity.EmergencyAlarmStatis;
import com.spring.jersy.hibernate.model.service.EmergencyAlarmStatisService;
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
public class EmergencyAlarmStatisServiceImpl implements EmergencyAlarmStatisService {

    @Autowired
    private EmergencyAlarmStatisDao emergencyAlarmStatisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EmergencyAlarmStatis.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(kabnum like '%" + key + "%' or account like '%" + key + "%'or unit like '%" + key + "%')"));
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
        pageList = emergencyAlarmStatisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EmergencyAlarmStatis findByid(Integer id) {
        return emergencyAlarmStatisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        emergencyAlarmStatisDao.delete(id);
    }

    @Override
    public void save(EmergencyAlarmStatis emergencyAlarmStatis) {
        emergencyAlarmStatisDao.save(emergencyAlarmStatis);
    }

    @Override
    public void saveOrUpd(EmergencyAlarmStatis emergencyAlarmStatis) {
        emergencyAlarmStatisDao.saveOrUpdate(emergencyAlarmStatis);
    }
}
