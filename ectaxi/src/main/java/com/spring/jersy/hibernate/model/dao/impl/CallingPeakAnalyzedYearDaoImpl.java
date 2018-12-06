package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CallingPeakAnalyzedYearDao;
import com.spring.jersy.hibernate.model.entity.CallingPeakAnalyzedYear;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CallingPeakAnalyzedYearDaoImpl extends BaseDaoImpl<CallingPeakAnalyzedYear, Integer> implements CallingPeakAnalyzedYearDao {
    public CallingPeakAnalyzedYearDaoImpl() {
        super(CallingPeakAnalyzedYear.class);
    }

    public CallingPeakAnalyzedYearDaoImpl(Class<CallingPeakAnalyzedYear> entity) {
        super(entity);
    }
}
