package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.TotalDurationAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.TotalDurationAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class TotalDurationAnalysisMonthDaoImpl extends BaseDaoImpl<TotalDurationAnalysisMonth, Integer> implements TotalDurationAnalysisMonthDao {
    public TotalDurationAnalysisMonthDaoImpl() {
        super(TotalDurationAnalysisMonth.class);
    }

    public TotalDurationAnalysisMonthDaoImpl(Class<TotalDurationAnalysisMonth> entity) {
        super(entity);
    }
}
