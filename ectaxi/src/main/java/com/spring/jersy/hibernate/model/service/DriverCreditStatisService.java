package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverCreditStatis;

import java.util.List;

public interface DriverCreditStatisService {

    public List<DriverCreditStatis> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

    public DriverCreditStatis findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverCreditStatis driverCreditStatis);

    public void saveOrUpd(DriverCreditStatis driverCreditStatis);

}
