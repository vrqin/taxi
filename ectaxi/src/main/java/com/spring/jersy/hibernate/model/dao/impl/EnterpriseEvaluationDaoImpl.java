package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseEvaluationDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseEvaluation;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseEvaluationDaoImpl extends BaseDaoImpl<EnterpriseEvaluation, Integer> implements EnterpriseEvaluationDao {
    public EnterpriseEvaluationDaoImpl() {
        super(EnterpriseEvaluation.class);
    }

    public EnterpriseEvaluationDaoImpl(Class<EnterpriseEvaluation> entity) {
        super(entity);
    }
}
