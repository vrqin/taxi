package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.MeasuredAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.MeasuredAnalysisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class MeasuredAnalysisDayDaoImpl extends BaseDaoImpl<MeasuredAnalysisDay, Integer> implements MeasuredAnalysisDayDao {
    public MeasuredAnalysisDayDaoImpl() {
        super(MeasuredAnalysisDay.class);
    }

    public MeasuredAnalysisDayDaoImpl(Class<MeasuredAnalysisDay> entity) {
        super(entity);
    }
}
