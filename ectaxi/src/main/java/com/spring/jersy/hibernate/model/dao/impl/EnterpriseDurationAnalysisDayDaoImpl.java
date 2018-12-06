package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseDurationAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseDurationAnalysisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseDurationAnalysisDayDaoImpl extends BaseDaoImpl<EnterpriseDurationAnalysisDay, Integer> implements EnterpriseDurationAnalysisDayDao {
    public EnterpriseDurationAnalysisDayDaoImpl() {
        super(EnterpriseDurationAnalysisDay.class);
    }

    public EnterpriseDurationAnalysisDayDaoImpl(Class<EnterpriseDurationAnalysisDay> entity) {
        super(entity);
    }
}
