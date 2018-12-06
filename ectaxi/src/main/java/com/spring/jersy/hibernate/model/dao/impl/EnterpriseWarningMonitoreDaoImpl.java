package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseWarningMonitoreDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseWarningMonitore;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseWarningMonitoreDaoImpl extends BaseDaoImpl<EnterpriseWarningMonitore, Integer> implements EnterpriseWarningMonitoreDao {
    public EnterpriseWarningMonitoreDaoImpl() {
        super(EnterpriseWarningMonitore.class);
    }

    public EnterpriseWarningMonitoreDaoImpl(Class<EnterpriseWarningMonitore> entity) {
        super(entity);
    }
}
