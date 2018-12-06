package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseDurationAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseDurationAnalysisYear;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseDurationAnalysisYearDaoImpl extends BaseDaoImpl<EnterpriseDurationAnalysisYear, Integer> implements EnterpriseDurationAnalysisYearDao {
    public EnterpriseDurationAnalysisYearDaoImpl() {
        super(EnterpriseDurationAnalysisYear.class);
    }

    public EnterpriseDurationAnalysisYearDaoImpl(Class<EnterpriseDurationAnalysisYear> entity) {
        super(entity);
    }
}
