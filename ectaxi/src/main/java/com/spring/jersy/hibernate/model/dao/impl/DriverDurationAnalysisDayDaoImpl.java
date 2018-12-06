package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverDurationAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.DriverDurationAnalysisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverDurationAnalysisDayDaoImpl extends BaseDaoImpl<DriverDurationAnalysisDay, Integer> implements DriverDurationAnalysisDayDao {
    public DriverDurationAnalysisDayDaoImpl() {
        super(DriverDurationAnalysisDay.class);
    }

    public DriverDurationAnalysisDayDaoImpl(Class<DriverDurationAnalysisDay> entity) {
        super(entity);
    }
}
