package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseInformationAnalysisCredit;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseInformationAnalysisCreditService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseInformationAnalysisCredit findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseInformationAnalysisCredit enterpriseInformationAnalysisCredit);

    public void saveOrUpd(EnterpriseInformationAnalysisCredit enterpriseInformationAnalysisCredit);

}
