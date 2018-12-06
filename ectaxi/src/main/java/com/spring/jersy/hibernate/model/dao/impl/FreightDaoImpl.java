package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.FreightDao;
import com.spring.jersy.hibernate.model.entity.Freight;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class FreightDaoImpl extends BaseDaoImpl<Freight, Integer> implements FreightDao {
    public FreightDaoImpl() {
        super(Freight.class);
    }

    public FreightDaoImpl(Class<Freight> entity) {
        super(entity);
    }
}
