package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.AuditTaskParameterDao;
import com.spring.jersy.hibernate.model.entity.AuditTaskParameter;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class AuditTaskParameterDaoImpl extends BaseDaoImpl<AuditTaskParameter, Integer> implements AuditTaskParameterDao {
    public AuditTaskParameterDaoImpl() {
        super(AuditTaskParameter.class);
    }

    public AuditTaskParameterDaoImpl(Class<AuditTaskParameter> entity) {
        super(entity);
    }
}