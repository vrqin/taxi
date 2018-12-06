package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.AuditExceptionDetailsDao;
import com.spring.jersy.hibernate.model.entity.AuditExceptionDetails;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class AuditExceptionDetailsDaoImpl extends BaseDaoImpl<AuditExceptionDetails, Integer> implements AuditExceptionDetailsDao {
    public AuditExceptionDetailsDaoImpl() {
        super(AuditExceptionDetails.class);
    }

    public AuditExceptionDetailsDaoImpl(Class<AuditExceptionDetails> entity) {
        super(entity);
    }
}
