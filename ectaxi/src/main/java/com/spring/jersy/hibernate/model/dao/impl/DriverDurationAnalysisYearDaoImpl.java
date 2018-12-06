package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverDurationAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.DriverDurationAnalysisYear;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverDurationAnalysisYearDaoImpl extends BaseDaoImpl<DriverDurationAnalysisYear, Integer> implements DriverDurationAnalysisYearDao {
    public DriverDurationAnalysisYearDaoImpl() {
        super(DriverDurationAnalysisYear.class);
    }

    public DriverDurationAnalysisYearDaoImpl(Class<DriverDurationAnalysisYear> entity) {
        super(entity);
    }
}
