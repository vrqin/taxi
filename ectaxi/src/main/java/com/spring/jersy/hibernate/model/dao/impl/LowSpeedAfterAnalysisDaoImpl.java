package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.LowSpeedAfterAnalysisDao;
import com.spring.jersy.hibernate.model.entity.LowSpeedAfterAnalysis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class LowSpeedAfterAnalysisDaoImpl extends BaseDaoImpl<LowSpeedAfterAnalysis, Integer> implements LowSpeedAfterAnalysisDao {
    public LowSpeedAfterAnalysisDaoImpl() {
        super(LowSpeedAfterAnalysis.class);
    }

    public LowSpeedAfterAnalysisDaoImpl(Class<LowSpeedAfterAnalysis> entity) {
        super(entity);
    }
}
