package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.AverageTimeIntervalAnalysisDao;
import com.spring.jersy.hibernate.model.entity.AverageTimeIntervalAnalysis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class AverageTimeIntervalAnalysisDaoImpl extends BaseDaoImpl<AverageTimeIntervalAnalysis, Integer> implements AverageTimeIntervalAnalysisDao {
    public AverageTimeIntervalAnalysisDaoImpl() {
        super(AverageTimeIntervalAnalysis.class);
    }

    public AverageTimeIntervalAnalysisDaoImpl(Class<AverageTimeIntervalAnalysis> entity) {
        super(entity);
    }
}
