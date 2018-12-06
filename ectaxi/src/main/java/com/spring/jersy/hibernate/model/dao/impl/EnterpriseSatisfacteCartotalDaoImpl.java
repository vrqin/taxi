package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseSatisfacteCartotalDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteCartotal;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseSatisfacteCartotalDaoImpl extends BaseDaoImpl<EnterpriseSatisfacteCartotal, Integer> implements EnterpriseSatisfacteCartotalDao {
    public EnterpriseSatisfacteCartotalDaoImpl() {
        super(EnterpriseSatisfacteCartotal.class);
    }

    public EnterpriseSatisfacteCartotalDaoImpl(Class<EnterpriseSatisfacteCartotal> entity) {
        super(entity);
    }
}
