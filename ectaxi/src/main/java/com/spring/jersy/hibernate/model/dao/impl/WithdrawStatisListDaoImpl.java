package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.WithdrawStatisListDao;
import com.spring.jersy.hibernate.model.entity.WithdrawStatisList;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class WithdrawStatisListDaoImpl extends BaseDaoImpl<WithdrawStatisList, Integer> implements WithdrawStatisListDao {
    public WithdrawStatisListDaoImpl() {
        super(WithdrawStatisList.class);
    }

    public WithdrawStatisListDaoImpl(Class<WithdrawStatisList> entity) {
        super(entity);
    }
}
