package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.TotalRevenueAnalysisDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface TotalRevenueAnalysisDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public TotalRevenueAnalysisDay findByid(Integer id);

    public void delete(Integer id);

    public void save(TotalRevenueAnalysisDay totalRevenueAnalysisDay);

    public void saveOrUpd(TotalRevenueAnalysisDay totalRevenueAnalysisDay);

}
