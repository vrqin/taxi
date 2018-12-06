package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.AuditTaskManagementDao;
import com.spring.jersy.hibernate.model.entity.AuditTaskManagement;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class AuditTaskManagementDaoImpl extends BaseDaoImpl<AuditTaskManagement, Integer> implements AuditTaskManagementDao {
    public AuditTaskManagementDaoImpl() {
        super(AuditTaskManagement.class);
    }

    public AuditTaskManagementDaoImpl(Class<AuditTaskManagement> entity) {
        super(entity);
    }
}
