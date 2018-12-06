package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverCreditDistribuDao;
import com.spring.jersy.hibernate.model.entity.DriverCreditDistribu;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverCreditDistribuDaoImpl extends BaseDaoImpl<DriverCreditDistribu, Integer> implements DriverCreditDistribuDao {
    public DriverCreditDistribuDaoImpl() {
        super(DriverCreditDistribu.class);
    }

    public DriverCreditDistribuDaoImpl(Class<DriverCreditDistribu> entity) {
        super(entity);
    }
}
