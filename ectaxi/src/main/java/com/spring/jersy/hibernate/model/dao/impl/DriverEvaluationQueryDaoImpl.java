package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverEvaluationQueryDao;
import com.spring.jersy.hibernate.model.entity.DriverEvaluationQuery;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverEvaluationQueryDaoImpl extends BaseDaoImpl<DriverEvaluationQuery, Integer> implements DriverEvaluationQueryDao {
    public DriverEvaluationQueryDaoImpl() {
        super(DriverEvaluationQuery.class);
    }

    public DriverEvaluationQueryDaoImpl(Class<DriverEvaluationQuery> entity) {
        super(entity);
    }
}
