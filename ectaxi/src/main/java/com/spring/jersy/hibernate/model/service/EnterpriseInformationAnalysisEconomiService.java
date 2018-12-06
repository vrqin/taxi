package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseInformationAnalysisEconomi;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseInformationAnalysisEconomiService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseInformationAnalysisEconomi findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseInformationAnalysisEconomi enterpriseInformationAnalysisEconomi);

    public void saveOrUpd(EnterpriseInformationAnalysisEconomi enterpriseInformationAnalysisEconomi);

}
