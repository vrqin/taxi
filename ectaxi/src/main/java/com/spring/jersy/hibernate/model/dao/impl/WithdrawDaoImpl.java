package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.WithdrawDao;
import com.spring.jersy.hibernate.model.entity.Withdraw;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class WithdrawDaoImpl extends BaseDaoImpl<Withdraw, Integer> implements WithdrawDao {
    public WithdrawDaoImpl() {
        super(Withdraw.class);
    }

    public WithdrawDaoImpl(Class<Withdraw> entity) {
        super(entity);
    }
}
