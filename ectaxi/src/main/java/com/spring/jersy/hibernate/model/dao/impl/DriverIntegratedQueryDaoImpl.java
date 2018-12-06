package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverIntegratedQueryDao;
import com.spring.jersy.hibernate.model.entity.DriverIntegratedQuery;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverIntegratedQueryDaoImpl extends BaseDaoImpl<DriverIntegratedQuery, Integer> implements DriverIntegratedQueryDao {
    public DriverIntegratedQueryDaoImpl() {
        super(DriverIntegratedQuery.class);
    }

    public DriverIntegratedQueryDaoImpl(Class<DriverIntegratedQuery> entity) {
        super(entity);
    }
}
