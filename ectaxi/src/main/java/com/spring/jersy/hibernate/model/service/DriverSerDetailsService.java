package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverSerDetails;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverSerDetailsService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverSerDetails findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverSerDetails driverSerDetails);

    public void saveOrUpd(DriverSerDetails driverSerDetails);

}
