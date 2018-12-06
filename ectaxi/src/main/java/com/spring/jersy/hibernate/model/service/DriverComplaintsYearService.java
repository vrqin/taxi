package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverComplaintsYear;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverComplaintsYearService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverComplaintsYear findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverComplaintsYear driverComplaintsYear);

    public void saveOrUpd(DriverComplaintsYear driverComplaintsYear);

}
