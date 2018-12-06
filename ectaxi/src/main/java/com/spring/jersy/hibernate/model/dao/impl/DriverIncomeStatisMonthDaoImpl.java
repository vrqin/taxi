package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverIncomeStatisMonthDao;
import com.spring.jersy.hibernate.model.entity.DriverIncomeStatisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverIncomeStatisMonthDaoImpl extends BaseDaoImpl<DriverIncomeStatisMonth, Integer> implements DriverIncomeStatisMonthDao {
    public DriverIncomeStatisMonthDaoImpl() {
        super(DriverIncomeStatisMonth.class);
    }

    public DriverIncomeStatisMonthDaoImpl(Class<DriverIncomeStatisMonth> entity) {
        super(entity);
    }
}
