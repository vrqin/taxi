package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverRevenueAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.DriverRevenueAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverRevenueAnalysisMonthDaoImpl extends BaseDaoImpl<DriverRevenueAnalysisMonth, Integer> implements DriverRevenueAnalysisMonthDao {
    public DriverRevenueAnalysisMonthDaoImpl() {
        super(DriverRevenueAnalysisMonth.class);
    }

    public DriverRevenueAnalysisMonthDaoImpl(Class<DriverRevenueAnalysisMonth> entity) {
        super(entity);
    }
}
