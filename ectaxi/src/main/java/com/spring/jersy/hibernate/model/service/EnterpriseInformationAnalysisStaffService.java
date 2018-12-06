package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseInformationAnalysisStaff;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseInformationAnalysisStaffService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseInformationAnalysisStaff findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseInformationAnalysisStaff enterpriseInformationAnalysisStaff);

    public void saveOrUpd(EnterpriseInformationAnalysisStaff enterpriseInformationAnalysisStaff);

}
