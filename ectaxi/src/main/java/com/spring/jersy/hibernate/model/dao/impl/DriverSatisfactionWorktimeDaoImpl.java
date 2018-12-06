package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverSatisfactionWorktimeDao;
import com.spring.jersy.hibernate.model.entity.DriverSatisfactionWorktime;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverSatisfactionWorktimeDaoImpl extends BaseDaoImpl<DriverSatisfactionWorktime, Integer> implements DriverSatisfactionWorktimeDao {
    public DriverSatisfactionWorktimeDaoImpl() {
        super(DriverSatisfactionWorktime.class);
    }

    public DriverSatisfactionWorktimeDaoImpl(Class<DriverSatisfactionWorktime> entity) {
        super(entity);
    }
}
