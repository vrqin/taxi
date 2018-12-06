package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseRevenueAnalysisYear;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseRevenueAnalysisYearService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseRevenueAnalysisYear findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseRevenueAnalysisYear enterpriseRevenueAnalysisYear);

    public void saveOrUpd(EnterpriseRevenueAnalysisYear enterpriseRevenueAnalysisYear);

}
