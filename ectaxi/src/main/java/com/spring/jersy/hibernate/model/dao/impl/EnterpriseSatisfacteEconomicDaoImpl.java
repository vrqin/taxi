package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseSatisfacteEconomicDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteEconomic;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseSatisfacteEconomicDaoImpl extends BaseDaoImpl<EnterpriseSatisfacteEconomic, Integer> implements EnterpriseSatisfacteEconomicDao {
    public EnterpriseSatisfacteEconomicDaoImpl() {
        super(EnterpriseSatisfacteEconomic.class);
    }

    public EnterpriseSatisfacteEconomicDaoImpl(Class<EnterpriseSatisfacteEconomic> entity) {
        super(entity);
    }
}
