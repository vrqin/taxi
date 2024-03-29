package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverSatisfactionStar;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverSatisfactionStarService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverSatisfactionStar findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverSatisfactionStar driverSatisfactionStar);

    public void saveOrUpd(DriverSatisfactionStar driverSatisfactionStar);

}
