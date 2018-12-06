package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseSatisfacteFundsDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteFunds;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseSatisfacteFundsDaoImpl extends BaseDaoImpl<EnterpriseSatisfacteFunds, Integer> implements EnterpriseSatisfacteFundsDao {
    public EnterpriseSatisfacteFundsDaoImpl() {
        super(EnterpriseSatisfacteFunds.class);
    }

    public EnterpriseSatisfacteFundsDaoImpl(Class<EnterpriseSatisfacteFunds> entity) {
        super(entity);
    }
}
