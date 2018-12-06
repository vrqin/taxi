package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.TotalRevenueAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.TotalRevenueAnalysisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class TotalRevenueAnalysisDayDaoImpl extends BaseDaoImpl<TotalRevenueAnalysisDay, Integer> implements TotalRevenueAnalysisDayDao {
    public TotalRevenueAnalysisDayDaoImpl() {
        super(TotalRevenueAnalysisDay.class);
    }

    public TotalRevenueAnalysisDayDaoImpl(Class<TotalRevenueAnalysisDay> entity) {
        super(entity);
    }
}
