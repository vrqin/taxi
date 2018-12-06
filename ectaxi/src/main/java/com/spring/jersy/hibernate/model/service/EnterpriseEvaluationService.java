package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseEvaluation;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseEvaluationService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseEvaluation findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseEvaluation enterpriseEvaluation);

    public void saveOrUpd(EnterpriseEvaluation enterpriseEvaluation);

}
