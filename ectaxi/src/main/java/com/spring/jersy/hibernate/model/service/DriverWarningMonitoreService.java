package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverWarningMonitore;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverWarningMonitoreService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverWarningMonitore findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverWarningMonitore driverWarningMonitore);

    public void saveOrUpd(DriverWarningMonitore driverWarningMonitore);

}
