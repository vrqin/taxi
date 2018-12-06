package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverDurationAnalysisDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverDurationAnalysisDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverDurationAnalysisDay findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverDurationAnalysisDay driverDurationAnalysisDay);

    public void saveOrUpd(DriverDurationAnalysisDay driverDurationAnalysisDay);

}
