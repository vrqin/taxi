package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PeaktimeIncomeAnalysisDao;
import com.spring.jersy.hibernate.model.entity.PeaktimeIncomeAnalysis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PeaktimeIncomeAnalysisDaoImpl extends BaseDaoImpl<PeaktimeIncomeAnalysis, Integer> implements PeaktimeIncomeAnalysisDao {
    public PeaktimeIncomeAnalysisDaoImpl() {
        super(PeaktimeIncomeAnalysis.class);
    }

    public PeaktimeIncomeAnalysisDaoImpl(Class<PeaktimeIncomeAnalysis> entity) {
        super(entity);
    }
}
