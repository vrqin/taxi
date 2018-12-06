package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseTipStatisMonthDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseTipStatisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseTipStatisMonthDaoImpl extends BaseDaoImpl<EnterpriseTipStatisMonth, Integer> implements EnterpriseTipStatisMonthDao {
    public EnterpriseTipStatisMonthDaoImpl() {
        super(EnterpriseTipStatisMonth.class);
    }

    public EnterpriseTipStatisMonthDaoImpl(Class<EnterpriseTipStatisMonth> entity) {
        super(entity);
    }
}
