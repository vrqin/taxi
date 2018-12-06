package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverWarningMonitoreDao;
import com.spring.jersy.hibernate.model.entity.DriverWarningMonitore;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverWarningMonitoreDaoImpl extends BaseDaoImpl<DriverWarningMonitore, Integer> implements DriverWarningMonitoreDao {
    public DriverWarningMonitoreDaoImpl() {
        super(DriverWarningMonitore.class);
    }

    public DriverWarningMonitoreDaoImpl(Class<DriverWarningMonitore> entity) {
        super(entity);
    }
}
