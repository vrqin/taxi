package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverIntegratedQuery;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverIntegratedQueryService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, Integer clientid) throws Exception;

    public DriverIntegratedQuery findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverIntegratedQuery driverIntegratedQuery);

    public void saveOrUpd(DriverIntegratedQuery driverIntegratedQuery);

}
