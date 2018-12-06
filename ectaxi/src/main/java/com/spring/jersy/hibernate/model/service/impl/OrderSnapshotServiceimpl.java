package com.spring.jersy.hibernate.model.service.impl;


import com.spring.jersy.hibernate.model.dao.OrderSnapshotDao;
import com.spring.jersy.hibernate.model.entity.OrderSnapshot;
import com.spring.jersy.hibernate.model.service.OrderSnapshotService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
@Service
public class OrderSnapshotServiceimpl implements OrderSnapshotService {

    @Autowired
    private OrderSnapshotDao orderSnapshotDao;

    @Override
    public List<OrderSnapshot> findListByTime(String begintime, String endtime) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(OrderSnapshot.class);
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("time", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("time", end));
        }
        dc.addOrder(Order.asc("time"));
        return orderSnapshotDao.findByDetachedCriteria(dc);
    }
}
