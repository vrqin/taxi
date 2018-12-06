package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverEvaluationDao;
import com.spring.jersy.hibernate.model.entity.DriverEvaluation;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverEvaluationDaoImpl extends BaseDaoImpl<DriverEvaluation, Integer> implements DriverEvaluationDao {
    public DriverEvaluationDaoImpl() {
        super(DriverEvaluation.class);
    }

    public DriverEvaluationDaoImpl(Class<DriverEvaluation> entity) {
        super(entity);
    }
}
