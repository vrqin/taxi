package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseTipStatisDayDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseTipStatisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseTipStatisDayDaoImpl extends BaseDaoImpl<EnterpriseTipStatisDay, Integer> implements EnterpriseTipStatisDayDao {
    public EnterpriseTipStatisDayDaoImpl() {
        super(EnterpriseTipStatisDay.class);
    }

    public EnterpriseTipStatisDayDaoImpl(Class<EnterpriseTipStatisDay> entity) {
        super(entity);
    }
}
