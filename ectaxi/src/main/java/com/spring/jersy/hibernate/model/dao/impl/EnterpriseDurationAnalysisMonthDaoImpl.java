package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseDurationAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseDurationAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseDurationAnalysisMonthDaoImpl extends BaseDaoImpl<EnterpriseDurationAnalysisMonth, Integer> implements EnterpriseDurationAnalysisMonthDao {
    public EnterpriseDurationAnalysisMonthDaoImpl() {
        super(EnterpriseDurationAnalysisMonth.class);
    }

    public EnterpriseDurationAnalysisMonthDaoImpl(Class<EnterpriseDurationAnalysisMonth> entity) {
        super(entity);
    }
}
