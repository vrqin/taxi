package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverComplaintsYearDao;
import com.spring.jersy.hibernate.model.entity.DriverComplaintsYear;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverComplaintsYearDaoImpl extends BaseDaoImpl<DriverComplaintsYear, Integer> implements DriverComplaintsYearDao {
    public DriverComplaintsYearDaoImpl() {
        super(DriverComplaintsYear.class);
    }

    public DriverComplaintsYearDaoImpl(Class<DriverComplaintsYear> entity) {
        super(entity);
    }
}
