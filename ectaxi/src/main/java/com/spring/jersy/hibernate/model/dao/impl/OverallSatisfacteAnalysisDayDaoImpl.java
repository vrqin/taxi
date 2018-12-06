package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OverallSatisfacteAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.OverallSatisfacteAnalysisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OverallSatisfacteAnalysisDayDaoImpl extends BaseDaoImpl<OverallSatisfacteAnalysisDay, Integer> implements OverallSatisfacteAnalysisDayDao {
    public OverallSatisfacteAnalysisDayDaoImpl() {
        super(OverallSatisfacteAnalysisDay.class);
    }

    public OverallSatisfacteAnalysisDayDaoImpl(Class<OverallSatisfacteAnalysisDay> entity) {
        super(entity);
    }
}
