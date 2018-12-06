package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseEvaluationQueryDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseEvaluationQuery;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseEvaluationQueryDaoImpl extends BaseDaoImpl<EnterpriseEvaluationQuery, Integer> implements EnterpriseEvaluationQueryDao {
    public EnterpriseEvaluationQueryDaoImpl() {
        super(EnterpriseEvaluationQuery.class);
    }

    public EnterpriseEvaluationQueryDaoImpl(Class<EnterpriseEvaluationQuery> entity) {
        super(entity);
    }
}
