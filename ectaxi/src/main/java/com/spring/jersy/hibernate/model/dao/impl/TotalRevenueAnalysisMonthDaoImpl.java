package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.TotalRevenueAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.TotalRevenueAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class TotalRevenueAnalysisMonthDaoImpl extends BaseDaoImpl<TotalRevenueAnalysisMonth, Integer> implements TotalRevenueAnalysisMonthDao {
    public TotalRevenueAnalysisMonthDaoImpl() {
        super(TotalRevenueAnalysisMonth.class);
    }

    public TotalRevenueAnalysisMonthDaoImpl(Class<TotalRevenueAnalysisMonth> entity) {
        super(entity);
    }
}
