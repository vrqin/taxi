package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.AverageVelocityAnalysisDao;
import com.spring.jersy.hibernate.model.entity.AverageVelocityAnalysis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class AverageVelocityAnalysisDaoImpl extends BaseDaoImpl<AverageVelocityAnalysis, Integer> implements AverageVelocityAnalysisDao {
    public AverageVelocityAnalysisDaoImpl() {
        super(AverageVelocityAnalysis.class);
    }

    public AverageVelocityAnalysisDaoImpl(Class<AverageVelocityAnalysis> entity) {
        super(entity);
    }
}
