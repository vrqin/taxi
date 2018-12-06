package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OperateRangeTimeMonthDao;
import com.spring.jersy.hibernate.model.entity.OperateRangeTimeMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OperateRangeTimeMonthDaoImpl extends BaseDaoImpl<OperateRangeTimeMonth, Integer> implements OperateRangeTimeMonthDao {
    public OperateRangeTimeMonthDaoImpl() {
        super(OperateRangeTimeMonth.class);
    }

    public OperateRangeTimeMonthDaoImpl(Class<OperateRangeTimeMonth> entity) {
        super(entity);
    }
}
