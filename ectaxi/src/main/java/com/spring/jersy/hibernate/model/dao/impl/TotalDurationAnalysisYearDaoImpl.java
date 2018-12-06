package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.TotalDurationAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.TotalDurationAnalysisYear;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class TotalDurationAnalysisYearDaoImpl extends BaseDaoImpl<TotalDurationAnalysisYear, Integer> implements TotalDurationAnalysisYearDao {
    public TotalDurationAnalysisYearDaoImpl() {
        super(TotalDurationAnalysisYear.class);
    }

    public TotalDurationAnalysisYearDaoImpl(Class<TotalDurationAnalysisYear> entity) {
        super(entity);
    }
}
