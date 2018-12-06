package com.spring.jersy.hibernate.model.service;


import com.spring.jersy.hibernate.model.entity.OrderSnapshot;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public interface OrderSnapshotService {

    public List<OrderSnapshot> findListByTime(String begintime, String endtime) throws Exception;

}
