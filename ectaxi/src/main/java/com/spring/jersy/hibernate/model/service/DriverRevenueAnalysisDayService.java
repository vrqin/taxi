package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverRevenueAnalysisDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverRevenueAnalysisDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverRevenueAnalysisDay findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverRevenueAnalysisDay driverRevenueAnalysisDay);

    public void saveOrUpd(DriverRevenueAnalysisDay driverRevenueAnalysisDay);

}
