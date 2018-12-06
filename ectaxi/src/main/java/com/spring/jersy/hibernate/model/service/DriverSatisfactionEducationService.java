package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverSatisfactionEducation;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverSatisfactionEducationService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverSatisfactionEducation findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverSatisfactionEducation driverSatisfactionEducation);

    public void saveOrUpd(DriverSatisfactionEducation driverSatisfactionEducation);

}
