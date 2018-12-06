package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CallingDuringAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.CallingDuringAnalysisYear;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CallingDuringAnalysisYearDaoImpl extends BaseDaoImpl<CallingDuringAnalysisYear, Integer> implements CallingDuringAnalysisYearDao {
    public CallingDuringAnalysisYearDaoImpl() {
        super(CallingDuringAnalysisYear.class);
    }

    public CallingDuringAnalysisYearDaoImpl(Class<CallingDuringAnalysisYear> entity) {
        super(entity);
    }
}
