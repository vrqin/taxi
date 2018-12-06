package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverIncomeStatisDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverIncomeStatisDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverIncomeStatisDay findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverIncomeStatisDay driverIncomeStatisDay);

    public void saveOrUpd(DriverIncomeStatisDay driverIncomeStatisDay);

}
