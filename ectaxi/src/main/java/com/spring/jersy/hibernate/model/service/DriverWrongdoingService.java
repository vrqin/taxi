package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverWrongdoing;

import java.util.List;

public interface DriverWrongdoingService {

    public List<DriverWrongdoing> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

    public DriverWrongdoing findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverWrongdoing driverWrongdoing);

    public void saveOrUpd(DriverWrongdoing driverWrongdoing);

}
