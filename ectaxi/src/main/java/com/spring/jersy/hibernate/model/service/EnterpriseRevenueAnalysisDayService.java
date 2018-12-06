package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseRevenueAnalysisDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseRevenueAnalysisDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseRevenueAnalysisDay findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseRevenueAnalysisDay enterpriseRevenueAnalysisDay);

    public void saveOrUpd(EnterpriseRevenueAnalysisDay enterpriseRevenueAnalysisDay);

}
