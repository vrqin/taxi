package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CallingDefaultAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.CallingDefaultAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CallingDefaultAnalysisMonthDaoImpl extends BaseDaoImpl<CallingDefaultAnalysisMonth, Integer> implements CallingDefaultAnalysisMonthDao {
    public CallingDefaultAnalysisMonthDaoImpl() {
        super(CallingDefaultAnalysisMonth.class);
    }

    public CallingDefaultAnalysisMonthDaoImpl(Class<CallingDefaultAnalysisMonth> entity) {
        super(entity);
    }
}
