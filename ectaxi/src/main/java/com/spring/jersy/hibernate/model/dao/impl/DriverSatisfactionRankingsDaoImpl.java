package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverSatisfactionRankingsDao;
import com.spring.jersy.hibernate.model.entity.DriverSatisfactionRankings;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverSatisfactionRankingsDaoImpl extends BaseDaoImpl<DriverSatisfactionRankings, Integer> implements DriverSatisfactionRankingsDao {
    public DriverSatisfactionRankingsDaoImpl() {
        super(DriverSatisfactionRankings.class);
    }

    public DriverSatisfactionRankingsDaoImpl(Class<DriverSatisfactionRankings> entity) {
        super(entity);
    }
}
