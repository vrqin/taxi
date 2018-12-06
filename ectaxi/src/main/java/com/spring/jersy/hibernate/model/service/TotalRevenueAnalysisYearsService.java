package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.TotalRevenueAnalysisYears;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface TotalRevenueAnalysisYearsService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public TotalRevenueAnalysisYears findByid(Integer id);

    public void delete(Integer id);

    public void save(TotalRevenueAnalysisYears totalRevenueAnalysisYears);

    public void saveOrUpd(TotalRevenueAnalysisYears totalRevenueAnalysisYears);

}
