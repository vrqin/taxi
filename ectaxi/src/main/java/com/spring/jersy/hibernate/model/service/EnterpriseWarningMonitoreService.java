package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseWarningMonitore;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseWarningMonitoreService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseWarningMonitore findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseWarningMonitore enterpriseWarningMonitore);

    public void saveOrUpd(EnterpriseWarningMonitore enterpriseWarningMonitore);

}
