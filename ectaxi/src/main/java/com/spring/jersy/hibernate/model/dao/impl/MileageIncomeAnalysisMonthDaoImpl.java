package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.MileageIncomeAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.MileageIncomeAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class MileageIncomeAnalysisMonthDaoImpl extends BaseDaoImpl<MileageIncomeAnalysisMonth, Integer> implements MileageIncomeAnalysisMonthDao {
    public MileageIncomeAnalysisMonthDaoImpl() {
        super(MileageIncomeAnalysisMonth.class);
    }

    public MileageIncomeAnalysisMonthDaoImpl(Class<MileageIncomeAnalysisMonth> entity) {
        super(entity);
    }
}
