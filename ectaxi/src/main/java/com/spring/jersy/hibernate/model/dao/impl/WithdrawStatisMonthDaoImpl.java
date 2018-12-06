package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.WithdrawStatisMonthDao;
import com.spring.jersy.hibernate.model.entity.WithdrawStatisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class WithdrawStatisMonthDaoImpl extends BaseDaoImpl<WithdrawStatisMonth, Integer> implements WithdrawStatisMonthDao {
    public WithdrawStatisMonthDaoImpl() {
        super(WithdrawStatisMonth.class);
    }

    public WithdrawStatisMonthDaoImpl(Class<WithdrawStatisMonth> entity) {
        super(entity);
    }
}
