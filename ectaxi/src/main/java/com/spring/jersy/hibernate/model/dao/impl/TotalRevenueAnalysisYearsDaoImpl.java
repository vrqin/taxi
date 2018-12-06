package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.TotalRevenueAnalysisYearsDao;
import com.spring.jersy.hibernate.model.entity.TotalRevenueAnalysisYears;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class TotalRevenueAnalysisYearsDaoImpl extends BaseDaoImpl<TotalRevenueAnalysisYears, Integer> implements TotalRevenueAnalysisYearsDao {
    public TotalRevenueAnalysisYearsDaoImpl() {
        super(TotalRevenueAnalysisYears.class);
    }

    public TotalRevenueAnalysisYearsDaoImpl(Class<TotalRevenueAnalysisYears> entity) {
        super(entity);
    }
}
