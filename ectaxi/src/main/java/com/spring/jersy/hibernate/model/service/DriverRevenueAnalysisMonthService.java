package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverRevenueAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverRevenueAnalysisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverRevenueAnalysisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverRevenueAnalysisMonth driverRevenueAnalysisMonth);

    public void saveOrUpd(DriverRevenueAnalysisMonth driverRevenueAnalysisMonth);

}
