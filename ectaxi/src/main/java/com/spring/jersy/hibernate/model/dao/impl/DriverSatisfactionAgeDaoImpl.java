package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverSatisfactionAgeDao;
import com.spring.jersy.hibernate.model.entity.DriverSatisfactionAge;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverSatisfactionAgeDaoImpl extends BaseDaoImpl<DriverSatisfactionAge, Integer> implements DriverSatisfactionAgeDao {
    public DriverSatisfactionAgeDaoImpl() {
        super(DriverSatisfactionAge.class);
    }

    public DriverSatisfactionAgeDaoImpl(Class<DriverSatisfactionAge> entity) {
        super(entity);
    }
}
