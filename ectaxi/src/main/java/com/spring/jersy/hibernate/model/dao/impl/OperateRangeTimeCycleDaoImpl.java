package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OperateRangeTimeCycleDao;
import com.spring.jersy.hibernate.model.entity.OperateRangeTimeCycle;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OperateRangeTimeCycleDaoImpl extends BaseDaoImpl<OperateRangeTimeCycle, Integer> implements OperateRangeTimeCycleDao {
    public OperateRangeTimeCycleDaoImpl() {
        super(OperateRangeTimeCycle.class);
    }

    public OperateRangeTimeCycleDaoImpl(Class<OperateRangeTimeCycle> entity) {
        super(entity);
    }
}
