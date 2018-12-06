package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverComplaintsMonthDao;
import com.spring.jersy.hibernate.model.entity.DriverComplaintsMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverComplaintsMonthDaoImpl extends BaseDaoImpl<DriverComplaintsMonth, Integer> implements DriverComplaintsMonthDao {
    public DriverComplaintsMonthDaoImpl() {
        super(DriverComplaintsMonth.class);
    }

    public DriverComplaintsMonthDaoImpl(Class<DriverComplaintsMonth> entity) {
        super(entity);
    }
}
