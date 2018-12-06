package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverRegDao;
import com.spring.jersy.hibernate.model.entity.DriverReg;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverRegDaoImpl extends BaseDaoImpl<DriverReg, Integer> implements DriverRegDao {
    public DriverRegDaoImpl() {
        super(DriverReg.class);
    }

    public DriverRegDaoImpl(Class<DriverReg> entity) {
        super(entity);
    }
}
