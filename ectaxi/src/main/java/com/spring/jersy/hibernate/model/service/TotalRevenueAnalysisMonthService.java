package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.TotalRevenueAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface TotalRevenueAnalysisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public TotalRevenueAnalysisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(TotalRevenueAnalysisMonth totalRevenueAnalysisMonth);

    public void saveOrUpd(TotalRevenueAnalysisMonth totalRevenueAnalysisMonth);

}
