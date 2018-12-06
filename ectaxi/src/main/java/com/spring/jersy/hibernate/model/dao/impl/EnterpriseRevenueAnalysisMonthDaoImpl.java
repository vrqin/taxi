package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseRevenueAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseRevenueAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseRevenueAnalysisMonthDaoImpl extends BaseDaoImpl<EnterpriseRevenueAnalysisMonth, Integer> implements EnterpriseRevenueAnalysisMonthDao {
    public EnterpriseRevenueAnalysisMonthDaoImpl() {
        super(EnterpriseRevenueAnalysisMonth.class);
    }

    public EnterpriseRevenueAnalysisMonthDaoImpl(Class<EnterpriseRevenueAnalysisMonth> entity) {
        super(entity);
    }
}
