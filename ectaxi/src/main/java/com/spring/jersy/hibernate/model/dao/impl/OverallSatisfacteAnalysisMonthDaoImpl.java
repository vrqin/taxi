package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OverallSatisfacteAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.OverallSatisfacteAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OverallSatisfacteAnalysisMonthDaoImpl extends BaseDaoImpl<OverallSatisfacteAnalysisMonth, Integer> implements OverallSatisfacteAnalysisMonthDao {
    public OverallSatisfacteAnalysisMonthDaoImpl() {
        super(OverallSatisfacteAnalysisMonth.class);
    }

    public OverallSatisfacteAnalysisMonthDaoImpl(Class<OverallSatisfacteAnalysisMonth> entity) {
        super(entity);
    }
}
