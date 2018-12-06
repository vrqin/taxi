package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OperationsPeakDao;
import com.spring.jersy.hibernate.model.entity.OperationsPeak;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OperationsPeakDaoImpl extends BaseDaoImpl<OperationsPeak, Integer> implements OperationsPeakDao {
    public OperationsPeakDaoImpl() {
        super(OperationsPeak.class);
    }

    public OperationsPeakDaoImpl(Class<OperationsPeak> entity) {
        super(entity);
    }
}
