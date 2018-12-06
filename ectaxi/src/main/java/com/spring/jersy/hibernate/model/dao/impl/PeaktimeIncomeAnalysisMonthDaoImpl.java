package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PeaktimeIncomeAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.PeaktimeIncomeAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PeaktimeIncomeAnalysisMonthDaoImpl extends BaseDaoImpl<PeaktimeIncomeAnalysisMonth, Integer> implements PeaktimeIncomeAnalysisMonthDao {
    public PeaktimeIncomeAnalysisMonthDaoImpl() {
        super(PeaktimeIncomeAnalysisMonth.class);
    }

    public PeaktimeIncomeAnalysisMonthDaoImpl(Class<PeaktimeIncomeAnalysisMonth> entity) {
        super(entity);
    }
}
