package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverSatisfactionStarDao;
import com.spring.jersy.hibernate.model.entity.DriverSatisfactionStar;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverSatisfactionStarDaoImpl extends BaseDaoImpl<DriverSatisfactionStar, Integer> implements DriverSatisfactionStarDao {
    public DriverSatisfactionStarDaoImpl() {
        super(DriverSatisfactionStar.class);
    }

    public DriverSatisfactionStarDaoImpl(Class<DriverSatisfactionStar> entity) {
        super(entity);
    }
}
