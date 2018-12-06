package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverReg;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverRegService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverReg findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverReg driverReg);

    public void saveOrUpd(DriverReg driverReg);

}
