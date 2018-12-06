package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseRevenueAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseRevenueAnalysisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseRevenueAnalysisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseRevenueAnalysisMonth enterpriseRevenueAnalysisMonth);

    public void saveOrUpd(EnterpriseRevenueAnalysisMonth enterpriseRevenueAnalysisMonth);

}
