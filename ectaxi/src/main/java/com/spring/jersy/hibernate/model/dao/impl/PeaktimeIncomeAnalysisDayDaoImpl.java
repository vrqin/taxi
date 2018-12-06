package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PeaktimeIncomeAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.PeaktimeIncomeAnalysisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PeaktimeIncomeAnalysisDayDaoImpl extends BaseDaoImpl<PeaktimeIncomeAnalysisDay, Integer> implements PeaktimeIncomeAnalysisDayDao {
    public PeaktimeIncomeAnalysisDayDaoImpl() {
        super(PeaktimeIncomeAnalysisDay.class);
    }

    public PeaktimeIncomeAnalysisDayDaoImpl(Class<PeaktimeIncomeAnalysisDay> entity) {
        super(entity);
    }
}
