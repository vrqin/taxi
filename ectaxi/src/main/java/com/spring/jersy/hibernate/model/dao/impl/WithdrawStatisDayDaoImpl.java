package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.WithdrawStatisDayDao;
import com.spring.jersy.hibernate.model.entity.WithdrawStatisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class WithdrawStatisDayDaoImpl extends BaseDaoImpl<WithdrawStatisDay, Integer> implements WithdrawStatisDayDao {
    public WithdrawStatisDayDaoImpl() {
        super(WithdrawStatisDay.class);
    }

    public WithdrawStatisDayDaoImpl(Class<WithdrawStatisDay> entity) {
        super(entity);
    }
}
