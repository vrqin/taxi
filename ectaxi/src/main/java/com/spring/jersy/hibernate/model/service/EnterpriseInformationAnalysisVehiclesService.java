package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseInformationAnalysisVehicles;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseInformationAnalysisVehiclesService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseInformationAnalysisVehicles findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseInformationAnalysisVehicles enterpriseInformationAnalysisVehicles);

    public void saveOrUpd(EnterpriseInformationAnalysisVehicles enterpriseInformationAnalysisVehicles);

}
