package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverSatisfactionAge;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverSatisfactionAgeService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverSatisfactionAge findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverSatisfactionAge driverSatisfactionAge);

    public void saveOrUpd(DriverSatisfactionAge driverSatisfactionAge);

}
