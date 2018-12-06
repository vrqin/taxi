package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseCreditStatisDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseCreditStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseCreditStatisDaoImpl extends BaseDaoImpl<EnterpriseCreditStatis, Integer> implements EnterpriseCreditStatisDao {
    public EnterpriseCreditStatisDaoImpl() {
        super(EnterpriseCreditStatis.class);
    }

    public EnterpriseCreditStatisDaoImpl(Class<EnterpriseCreditStatis> entity) {
        super(entity);
    }
}
