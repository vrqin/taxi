package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverSatisfactionRankings;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverSatisfactionRankingsService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverSatisfactionRankings findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverSatisfactionRankings driverSatisfactionRankings);

    public void saveOrUpd(DriverSatisfactionRankings driverSatisfactionRankings);

}
