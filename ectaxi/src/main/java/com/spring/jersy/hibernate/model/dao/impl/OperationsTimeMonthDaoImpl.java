package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OperationsTimeMonthDao;
import com.spring.jersy.hibernate.model.entity.OperationsTimeMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OperationsTimeMonthDaoImpl extends BaseDaoImpl<OperationsTimeMonth, Integer> implements OperationsTimeMonthDao {
    public OperationsTimeMonthDaoImpl() {
        super(OperationsTimeMonth.class);
    }

    public OperationsTimeMonthDaoImpl(Class<OperationsTimeMonth> entity) {
        super(entity);
    }
}
