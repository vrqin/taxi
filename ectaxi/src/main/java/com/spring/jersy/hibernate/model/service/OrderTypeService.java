package com.spring.jersy.hibernate.model.service;


import com.spring.jersy.hibernate.model.entity.OrderType;

import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public interface OrderTypeService {

    public List<OrderType> findType();

}
