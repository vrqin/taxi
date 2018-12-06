package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.RouteAlarmDetails;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface RouteAlarmDetailsService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public RouteAlarmDetails findByid(Integer id);

    public void delete(Integer id);

    public void save(RouteAlarmDetails routeAlarmDetails);

    public void saveOrUpd(RouteAlarmDetails routeAlarmDetails);

}
