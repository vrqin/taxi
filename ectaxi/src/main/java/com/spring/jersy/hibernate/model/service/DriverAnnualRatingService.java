package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverAnnualRating;

import java.util.List;

public interface DriverAnnualRatingService {

    public List<DriverAnnualRating> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

    public DriverAnnualRating findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverAnnualRating driverAnnualRating);

    public void saveOrUpd(DriverAnnualRating driverAnnualRating);

}
