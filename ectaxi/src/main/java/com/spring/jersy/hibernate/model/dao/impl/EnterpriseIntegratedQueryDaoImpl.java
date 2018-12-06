package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseIntegratedQueryDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseIntegratedQuery;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseIntegratedQueryDaoImpl extends BaseDaoImpl<EnterpriseIntegratedQuery, Integer> implements EnterpriseIntegratedQueryDao {
    public EnterpriseIntegratedQueryDaoImpl() {
        super(EnterpriseIntegratedQuery.class);
    }

    public EnterpriseIntegratedQueryDaoImpl(Class<EnterpriseIntegratedQuery> entity) {
        super(entity);
    }
}
