package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverDurationAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.DriverDurationAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverDurationAnalysisMonthDaoImpl extends BaseDaoImpl<DriverDurationAnalysisMonth, Integer> implements DriverDurationAnalysisMonthDao {
    public DriverDurationAnalysisMonthDaoImpl() {
        super(DriverDurationAnalysisMonth.class);
    }

    public DriverDurationAnalysisMonthDaoImpl(Class<DriverDurationAnalysisMonth> entity) {
        super(entity);
    }
}
