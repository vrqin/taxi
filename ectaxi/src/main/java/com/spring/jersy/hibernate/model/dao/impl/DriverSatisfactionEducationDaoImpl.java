package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverSatisfactionEducationDao;
import com.spring.jersy.hibernate.model.entity.DriverSatisfactionEducation;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverSatisfactionEducationDaoImpl extends BaseDaoImpl<DriverSatisfactionEducation, Integer> implements DriverSatisfactionEducationDao {
    public DriverSatisfactionEducationDaoImpl() {
        super(DriverSatisfactionEducation.class);
    }

    public DriverSatisfactionEducationDaoImpl(Class<DriverSatisfactionEducation> entity) {
        super(entity);
    }
}
