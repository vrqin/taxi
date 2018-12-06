package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.MeasuredAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.MeasuredAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class MeasuredAnalysisMonthDaoImpl extends BaseDaoImpl<MeasuredAnalysisMonth, Integer> implements MeasuredAnalysisMonthDao {
    public MeasuredAnalysisMonthDaoImpl() {
        super(MeasuredAnalysisMonth.class);
    }

    public MeasuredAnalysisMonthDaoImpl(Class<MeasuredAnalysisMonth> entity) {
        super(entity);
    }
}
