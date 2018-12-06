package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OverallSatisfacteAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.OverallSatisfacteAnalysisYear;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OverallSatisfacteAnalysisYearDaoImpl extends BaseDaoImpl<OverallSatisfacteAnalysisYear, Integer> implements OverallSatisfacteAnalysisYearDao {
    public OverallSatisfacteAnalysisYearDaoImpl() {
        super(OverallSatisfacteAnalysisYear.class);
    }

    public OverallSatisfacteAnalysisYearDaoImpl(Class<OverallSatisfacteAnalysisYear> entity) {
        super(entity);
    }
}
