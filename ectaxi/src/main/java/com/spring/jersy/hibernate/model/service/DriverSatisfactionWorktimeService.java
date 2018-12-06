package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverSatisfactionWorktime;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverSatisfactionWorktimeService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverSatisfactionWorktime findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverSatisfactionWorktime driverSatisfactionWorktime);

    public void saveOrUpd(DriverSatisfactionWorktime driverSatisfactionWorktime);

}
