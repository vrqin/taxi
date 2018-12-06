package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CallingPeakAnalyzedDayDao;
import com.spring.jersy.hibernate.model.entity.CallingPeakAnalyzedDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CallingPeakAnalyzedDayDaoImpl extends BaseDaoImpl<CallingPeakAnalyzedDay, Integer> implements CallingPeakAnalyzedDayDao {
    public CallingPeakAnalyzedDayDaoImpl() {
        super(CallingPeakAnalyzedDay.class);
    }

    public CallingPeakAnalyzedDayDaoImpl(Class<CallingPeakAnalyzedDay> entity) {
        super(entity);
    }
}
