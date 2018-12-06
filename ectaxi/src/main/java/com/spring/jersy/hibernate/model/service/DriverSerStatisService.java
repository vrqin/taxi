package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverSerStatis;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverSerStatisService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverSerStatis findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverSerStatis driverSerStatis);

    public void saveOrUpd(DriverSerStatis driverSerStatis);

}
