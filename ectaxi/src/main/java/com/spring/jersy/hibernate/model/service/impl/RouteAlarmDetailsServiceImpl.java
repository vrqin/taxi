package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.RouteAlarmDetailsDao;
import com.spring.jersy.hibernate.model.entity.RouteAlarmDetails;
import com.spring.jersy.hibernate.model.service.RouteAlarmDetailsService;
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
public class RouteAlarmDetailsServiceImpl implements RouteAlarmDetailsService {

    @Autowired
    private RouteAlarmDetailsDao routeAlarmDetailsDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(RouteAlarmDetails.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(kabnum like '%" + key + "%' or account like '%" + key + "%'or linename like '%" + key + "%')"));
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
        pageList = routeAlarmDetailsDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public RouteAlarmDetails findByid(Integer id) {
        return routeAlarmDetailsDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        routeAlarmDetailsDao.delete(id);
    }

    @Override
    public void save(RouteAlarmDetails routeAlarmDetails) {
        routeAlarmDetailsDao.save(routeAlarmDetails);
    }

    @Override
    public void saveOrUpd(RouteAlarmDetails routeAlarmDetails) {
        routeAlarmDetailsDao.saveOrUpdate(routeAlarmDetails);
    }
}
