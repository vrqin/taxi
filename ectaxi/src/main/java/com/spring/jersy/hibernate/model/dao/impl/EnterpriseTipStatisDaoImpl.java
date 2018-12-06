package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseTipStatisDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseTipStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseTipStatisDaoImpl extends BaseDaoImpl<EnterpriseTipStatis, Integer> implements EnterpriseTipStatisDao {
    public EnterpriseTipStatisDaoImpl() {
        super(EnterpriseTipStatis.class);
    }

    public EnterpriseTipStatisDaoImpl(Class<EnterpriseTipStatis> entity) {
        super(entity);
    }
}
