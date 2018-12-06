package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverWrongdoingDao;
import com.spring.jersy.hibernate.model.entity.DriverWrongdoing;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverWrongdoingDaoImpl extends BaseDaoImpl<DriverWrongdoing, Integer> implements DriverWrongdoingDao {
    public DriverWrongdoingDaoImpl() {
        super(DriverWrongdoing.class);
    }

    public DriverWrongdoingDaoImpl(Class<DriverWrongdoing> entity) {
        super(entity);
    }
}
