package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverRevenueAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.DriverRevenueAnalysisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverRevenueAnalysisDayDaoImpl extends BaseDaoImpl<DriverRevenueAnalysisDay, Integer> implements DriverRevenueAnalysisDayDao {
    public DriverRevenueAnalysisDayDaoImpl() {
        super(DriverRevenueAnalysisDay.class);
    }

    public DriverRevenueAnalysisDayDaoImpl(Class<DriverRevenueAnalysisDay> entity) {
        super(entity);
    }
}
