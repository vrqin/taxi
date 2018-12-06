package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseEvaluationQuery;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseEvaluationQueryService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int level) throws Exception;

    public EnterpriseEvaluationQuery findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseEvaluationQuery enterpriseEvaluationQuery);

    public void saveOrUpd(EnterpriseEvaluationQuery enterpriseEvaluationQuery);

}
