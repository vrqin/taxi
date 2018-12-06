package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverIncomeStatis;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverIncomeStatisService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverIncomeStatis findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverIncomeStatis driverIncomeStatis);

    public void saveOrUpd(DriverIncomeStatis driverIncomeStatis);

}
