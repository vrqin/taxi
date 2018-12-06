package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverSerDetailsDao;
import com.spring.jersy.hibernate.model.entity.DriverSerDetails;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverSerDetailsDaoImpl extends BaseDaoImpl<DriverSerDetails, Integer> implements DriverSerDetailsDao {
    public DriverSerDetailsDaoImpl() {
        super(DriverSerDetails.class);
    }

    public DriverSerDetailsDaoImpl(Class<DriverSerDetails> entity) {
        super(entity);
    }
}
