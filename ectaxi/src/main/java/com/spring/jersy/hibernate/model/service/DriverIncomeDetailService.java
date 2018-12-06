package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverIncomeDetail;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverIncomeDetailService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverIncomeDetail findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverIncomeDetail driverIncomeDetail);

    public void saveOrUpd(DriverIncomeDetail driverIncomeDetail);

}
