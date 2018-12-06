package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CallingDefaultAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.CallingDefaultAnalysisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CallingDefaultAnalysisDayDaoImpl extends BaseDaoImpl<CallingDefaultAnalysisDay, Integer> implements CallingDefaultAnalysisDayDao {
    public CallingDefaultAnalysisDayDaoImpl() {
        super(CallingDefaultAnalysisDay.class);
    }

    public CallingDefaultAnalysisDayDaoImpl(Class<CallingDefaultAnalysisDay> entity) {
        super(entity);
    }
}
