package com.spring.jersy.hibernate.model.service.impl;


import com.spring.jersy.hibernate.model.dao.CallOrderDao;
import com.spring.jersy.hibernate.model.entity.CallOrder;
import com.spring.jersy.hibernate.model.service.CallOrderService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/5/9.
 */
@Service
public class CallOrderServiceImpl implements CallOrderService {

    @Autowired
    private CallOrderDao callOrderDao;

    @Override
    public List<CallOrder> findAllList(String orderid) {
        DetachedCriteria dc = DetachedCriteria.forClass(CallOrder.class);
        dc.add(Restrictions.sqlRestriction("orderid =" + orderid + "  GROUP BY nodeid"));
        return callOrderDao.findByDetachedCriteria(dc);

    }
}
