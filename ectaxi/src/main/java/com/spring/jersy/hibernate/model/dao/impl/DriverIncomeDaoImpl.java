package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverIncomeDao;
import com.spring.jersy.hibernate.model.entity.DriverIncome;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverIncomeDaoImpl extends BaseDaoImpl<DriverIncome, Integer> implements DriverIncomeDao {
    public DriverIncomeDaoImpl() {
        super(DriverIncome.class);
    }

    public DriverIncomeDaoImpl(Class<DriverIncome> entity) {
        super(entity);
    }
}
