package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CallingDuringAnalysisTimeDao;
import com.spring.jersy.hibernate.model.entity.CallingDuringAnalysisTime;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CallingDuringAnalysisTimeDaoImpl extends BaseDaoImpl<CallingDuringAnalysisTime, Integer> implements CallingDuringAnalysisTimeDao {
    public CallingDuringAnalysisTimeDaoImpl() {
        super(CallingDuringAnalysisTime.class);
    }

    public CallingDuringAnalysisTimeDaoImpl(Class<CallingDuringAnalysisTime> entity) {
        super(entity);
    }
}
