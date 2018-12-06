package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EmergencyAlarmDetailsDao;
import com.spring.jersy.hibernate.model.entity.EmergencyAlarmDetails;
import com.spring.jersy.hibernate.model.service.EmergencyAlarmDetailsService;
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
public class EmergencyAlarmDetailsServiceImpl implements EmergencyAlarmDetailsService {

    @Autowired
    private EmergencyAlarmDetailsDao emergencyAlarmDetailsDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EmergencyAlarmDetails.class);

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

        if (type > (-1)) {
            dc.add(Restrictions.eq("type", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = emergencyAlarmDetailsDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EmergencyAlarmDetails findByid(Integer id) {
        return emergencyAlarmDetailsDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        emergencyAlarmDetailsDao.delete(id);
    }

    @Override
    public void save(EmergencyAlarmDetails emergencyAlarmDetails) {
        emergencyAlarmDetailsDao.save(emergencyAlarmDetails);
    }

    @Override
    public void saveOrUpd(EmergencyAlarmDetails emergencyAlarmDetails) {
        emergencyAlarmDetailsDao.saveOrUpdate(emergencyAlarmDetails);
    }
}
