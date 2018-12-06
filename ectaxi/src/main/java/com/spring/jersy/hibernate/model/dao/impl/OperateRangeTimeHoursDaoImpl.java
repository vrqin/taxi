package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OperateRangeTimeHoursDao;
import com.spring.jersy.hibernate.model.entity.OperateRangeTimeHours;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OperateRangeTimeHoursDaoImpl extends BaseDaoImpl<OperateRangeTimeHours, Integer> implements OperateRangeTimeHoursDao {
    public OperateRangeTimeHoursDaoImpl() {
        super(OperateRangeTimeHours.class);
    }

    public OperateRangeTimeHoursDaoImpl(Class<OperateRangeTimeHours> entity) {
        super(entity);
    }
}
