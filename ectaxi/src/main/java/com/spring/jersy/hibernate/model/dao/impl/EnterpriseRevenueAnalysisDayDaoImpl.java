package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseRevenueAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseRevenueAnalysisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseRevenueAnalysisDayDaoImpl extends BaseDaoImpl<EnterpriseRevenueAnalysisDay, Integer> implements EnterpriseRevenueAnalysisDayDao {
    public EnterpriseRevenueAnalysisDayDaoImpl() {
        super(EnterpriseRevenueAnalysisDay.class);
    }

    public EnterpriseRevenueAnalysisDayDaoImpl(Class<EnterpriseRevenueAnalysisDay> entity) {
        super(entity);
    }
}
