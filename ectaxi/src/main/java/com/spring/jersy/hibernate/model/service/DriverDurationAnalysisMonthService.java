package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverDurationAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverDurationAnalysisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverDurationAnalysisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverDurationAnalysisMonth driverDurationAnalysisMonth);

    public void saveOrUpd(DriverDurationAnalysisMonth driverDurationAnalysisMonth);

}
