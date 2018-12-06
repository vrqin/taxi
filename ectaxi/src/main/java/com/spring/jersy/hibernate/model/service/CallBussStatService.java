package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CallBussStat;
import com.spring.jersy.hibernate.publics.bean.MonitorBean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/19.
 */
public interface CallBussStatService {
    public List<CallBussStat> findList();

    public List<CallBussStat> findLastCallBussStat(int length, int clientid);

    public List<MonitorBean> findLastMonitor(int clientid);

}
