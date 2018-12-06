package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseCreditDistribuDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseCreditDistribu;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseCreditDistribuDaoImpl extends BaseDaoImpl<EnterpriseCreditDistribu, Integer> implements EnterpriseCreditDistribuDao {
    public EnterpriseCreditDistribuDaoImpl() {
        super(EnterpriseCreditDistribu.class);
    }

    public EnterpriseCreditDistribuDaoImpl(Class<EnterpriseCreditDistribu> entity) {
        super(entity);
    }
}
