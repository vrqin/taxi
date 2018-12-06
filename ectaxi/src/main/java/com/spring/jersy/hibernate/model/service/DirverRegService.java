package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverReg;

import java.util.List;

public interface DirverRegService {

    public List<DriverReg> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

    public DriverReg findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverReg dirverReg);

    public void saveOrUpd(DriverReg dirverReg);

}
