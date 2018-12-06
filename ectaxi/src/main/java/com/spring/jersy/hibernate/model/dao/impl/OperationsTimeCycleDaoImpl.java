package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OperationsTimeCycleDao;
import com.spring.jersy.hibernate.model.entity.OperationsTimeCycle;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OperationsTimeCycleDaoImpl extends BaseDaoImpl<OperationsTimeCycle, Integer> implements OperationsTimeCycleDao {
    public OperationsTimeCycleDaoImpl() {
        super(OperationsTimeCycle.class);
    }

    public OperationsTimeCycleDaoImpl(Class<OperationsTimeCycle> entity) {
        super(entity);
    }
}
