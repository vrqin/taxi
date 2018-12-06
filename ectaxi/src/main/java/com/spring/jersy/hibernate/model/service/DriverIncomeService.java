package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverIncome;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverIncomeService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverIncome findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverIncome driverIncome);

    public void saveOrUpd(DriverIncome driverIncome);

}
