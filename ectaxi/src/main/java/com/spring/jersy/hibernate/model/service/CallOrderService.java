package com.spring.jersy.hibernate.model.service;


import com.spring.jersy.hibernate.model.entity.CallOrder;

import java.util.List;

/**
 * Created by Administrator on 2016/5/9.
 */
public interface CallOrderService {

    public List<CallOrder> findAllList(String orderid);

}
