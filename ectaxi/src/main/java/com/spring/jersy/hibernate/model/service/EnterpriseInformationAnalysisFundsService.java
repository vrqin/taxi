package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseInformationAnalysisFunds;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseInformationAnalysisFundsService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseInformationAnalysisFunds findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseInformationAnalysisFunds enterpriseInformationAnalysisFunds);

    public void saveOrUpd(EnterpriseInformationAnalysisFunds enterpriseInformationAnalysisFunds);

}
