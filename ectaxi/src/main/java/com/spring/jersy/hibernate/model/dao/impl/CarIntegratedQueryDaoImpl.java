package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CarIntegratedQueryDao;
import com.spring.jersy.hibernate.model.entity.CarIntegratedQuery;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CarIntegratedQueryDaoImpl extends BaseDaoImpl<CarIntegratedQuery, Integer> implements CarIntegratedQueryDao {
    public CarIntegratedQueryDaoImpl() {
        super(CarIntegratedQuery.class);
    }

    public CarIntegratedQueryDaoImpl(Class<CarIntegratedQuery> entity) {
        super(entity);
    }
}
