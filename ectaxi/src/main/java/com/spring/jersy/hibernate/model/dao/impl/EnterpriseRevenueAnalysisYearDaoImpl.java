package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseRevenueAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseRevenueAnalysisYear;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseRevenueAnalysisYearDaoImpl extends BaseDaoImpl<EnterpriseRevenueAnalysisYear, Integer> implements EnterpriseRevenueAnalysisYearDao {
    public EnterpriseRevenueAnalysisYearDaoImpl() {
        super(EnterpriseRevenueAnalysisYear.class);
    }

    public EnterpriseRevenueAnalysisYearDaoImpl(Class<EnterpriseRevenueAnalysisYear> entity) {
        super(entity);
    }
}
