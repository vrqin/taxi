package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseCorporateWrongdoingDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseCorporateWrongdoing;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseCorporateWrongdoingDaoImpl extends BaseDaoImpl<EnterpriseCorporateWrongdoing, Integer> implements EnterpriseCorporateWrongdoingDao {
    public EnterpriseCorporateWrongdoingDaoImpl() {
        super(EnterpriseCorporateWrongdoing.class);
    }

    public EnterpriseCorporateWrongdoingDaoImpl(Class<EnterpriseCorporateWrongdoing> entity) {
        super(entity);
    }
}
