package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.MileageIncomeAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.MileageIncomeAnalysisYear;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class MileageIncomeAnalysisYearDaoImpl extends BaseDaoImpl<MileageIncomeAnalysisYear, Integer> implements MileageIncomeAnalysisYearDao {
    public MileageIncomeAnalysisYearDaoImpl() {
        super(MileageIncomeAnalysisYear.class);
    }

    public MileageIncomeAnalysisYearDaoImpl(Class<MileageIncomeAnalysisYear> entity) {
        super(entity);
    }
}
