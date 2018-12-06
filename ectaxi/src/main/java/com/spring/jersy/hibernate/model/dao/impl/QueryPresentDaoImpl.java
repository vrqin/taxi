package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.QueryPresentDao;
import com.spring.jersy.hibernate.model.entity.QueryPresent;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class QueryPresentDaoImpl extends BaseDaoImpl<QueryPresent, Integer> implements QueryPresentDao {
    public QueryPresentDaoImpl() {
        super(QueryPresent.class);
    }

    public QueryPresentDaoImpl(Class<QueryPresent> entity) {
        super(entity);
    }
}
