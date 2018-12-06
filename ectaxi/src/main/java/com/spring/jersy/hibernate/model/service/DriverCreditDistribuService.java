package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverCreditDistribu;

import java.util.List;

public interface DriverCreditDistribuService {

    public List<DriverCreditDistribu> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

    public DriverCreditDistribu findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverCreditDistribu driverCreditDistribu);

    public void saveOrUpd(DriverCreditDistribu driverCreditDistribu);

}
