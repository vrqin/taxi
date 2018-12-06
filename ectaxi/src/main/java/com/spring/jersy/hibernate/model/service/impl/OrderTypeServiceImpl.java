package com.spring.jersy.hibernate.model.service.impl;


import com.spring.jersy.hibernate.model.dao.OrderTypeDao;
import com.spring.jersy.hibernate.model.entity.OrderType;
import com.spring.jersy.hibernate.model.service.OrderTypeService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
@Service
public class OrderTypeServiceImpl implements OrderTypeService {

    @Autowired
    private OrderTypeDao orderTypeDao;

    @Override
    public List<OrderType> findType() {
        DetachedCriteria dc = DetachedCriteria.forClass(OrderType.class);
        dc.addOrder(Order.asc("typeid"));
        return orderTypeDao.findByDetachedCriteria(dc);
    }

}
