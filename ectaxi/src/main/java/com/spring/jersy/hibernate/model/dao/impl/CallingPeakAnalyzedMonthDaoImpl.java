package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CallingPeakAnalyzedMonthDao;
import com.spring.jersy.hibernate.model.entity.CallingPeakAnalyzedMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CallingPeakAnalyzedMonthDaoImpl extends BaseDaoImpl<CallingPeakAnalyzedMonth, Integer> implements CallingPeakAnalyzedMonthDao {
    public CallingPeakAnalyzedMonthDaoImpl() {
        super(CallingPeakAnalyzedMonth.class);
    }

    public CallingPeakAnalyzedMonthDaoImpl(Class<CallingPeakAnalyzedMonth> entity) {
        super(entity);
    }
}
