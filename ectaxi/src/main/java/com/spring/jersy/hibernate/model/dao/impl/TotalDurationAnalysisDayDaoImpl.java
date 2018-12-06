package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.TotalDurationAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.TotalDurationAnalysisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class TotalDurationAnalysisDayDaoImpl extends BaseDaoImpl<TotalDurationAnalysisDay, Integer> implements TotalDurationAnalysisDayDao {
    public TotalDurationAnalysisDayDaoImpl() {
        super(TotalDurationAnalysisDay.class);
    }

    public TotalDurationAnalysisDayDaoImpl(Class<TotalDurationAnalysisDay> entity) {
        super(entity);
    }
}
