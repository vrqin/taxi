package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverCreditFiles;

import java.util.List;

public interface DriverCreditFilesService {

    public List<DriverCreditFiles> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

    public DriverCreditFiles findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverCreditFiles driverCreditFiles);

    public void saveOrUpd(DriverCreditFiles driverCreditFiles);

}
