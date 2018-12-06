package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CallingDefaultAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.CallingDefaultAnalysisYear;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CallingDefaultAnalysisYearDaoImpl extends BaseDaoImpl<CallingDefaultAnalysisYear, Integer> implements CallingDefaultAnalysisYearDao {
    public CallingDefaultAnalysisYearDaoImpl() {
        super(CallingDefaultAnalysisYear.class);
    }

    public CallingDefaultAnalysisYearDaoImpl(Class<CallingDefaultAnalysisYear> entity) {
        super(entity);
    }
}
