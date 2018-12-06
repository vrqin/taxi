package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.MileageIncomeAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.MileageIncomeAnalysisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class MileageIncomeAnalysisDayDaoImpl extends BaseDaoImpl<MileageIncomeAnalysisDay, Integer> implements MileageIncomeAnalysisDayDao {
    public MileageIncomeAnalysisDayDaoImpl() {
        super(MileageIncomeAnalysisDay.class);
    }

    public MileageIncomeAnalysisDayDaoImpl(Class<MileageIncomeAnalysisDay> entity) {
        super(entity);
    }
}
