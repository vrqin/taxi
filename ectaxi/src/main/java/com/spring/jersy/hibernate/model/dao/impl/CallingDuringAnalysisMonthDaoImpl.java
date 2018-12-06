package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CallingDuringAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.CallingDuringAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CallingDuringAnalysisMonthDaoImpl extends BaseDaoImpl<CallingDuringAnalysisMonth, Integer> implements CallingDuringAnalysisMonthDao {
    public CallingDuringAnalysisMonthDaoImpl() {
        super(CallingDuringAnalysisMonth.class);
    }

    public CallingDuringAnalysisMonthDaoImpl(Class<CallingDuringAnalysisMonth> entity) {
        super(entity);
    }
}
