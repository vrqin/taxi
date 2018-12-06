package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.RouteAlarmStatisDao;
import com.spring.jersy.hibernate.model.entity.RouteAlarmStatis;
import com.spring.jersy.hibernate.model.service.RouteAlarmStatisService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RouteAlarmStatisServiceImpl implements RouteAlarmStatisService {

    @Autowired
    private RouteAlarmStatisDao routeAlarmStatisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(RouteAlarmStatis.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(kabnum like '%" + key + "%' or driver like '%" + key + "%'or linename like '%" + key + "%')"));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = routeAlarmStatisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public RouteAlarmStatis findByid(Integer id) {
        return routeAlarmStatisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        routeAlarmStatisDao.delete(id);
    }

    @Override
    public void save(RouteAlarmStatis routeAlarmStatis) {
        routeAlarmStatisDao.save(routeAlarmStatis);
    }

    @Override
    public void saveOrUpd(RouteAlarmStatis routeAlarmStatis) {
        routeAlarmStatisDao.saveOrUpdate(routeAlarmStatis);
    }
}
