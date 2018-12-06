package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseIntegratedQuery;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseIntegratedQueryService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, Integer clientid) throws Exception;

    public EnterpriseIntegratedQuery findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseIntegratedQuery enterpriseIntegratedQuery);

    public void saveOrUpd(EnterpriseIntegratedQuery enterpriseIntegratedQuery);

}
