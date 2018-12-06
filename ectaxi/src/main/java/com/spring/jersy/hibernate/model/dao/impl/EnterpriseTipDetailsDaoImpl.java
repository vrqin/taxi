package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseTipDetailsDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseTipDetails;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseTipDetailsDaoImpl extends BaseDaoImpl<EnterpriseTipDetails, Integer> implements EnterpriseTipDetailsDao {
    public EnterpriseTipDetailsDaoImpl() {
        super(EnterpriseTipDetails.class);
    }

    public EnterpriseTipDetailsDaoImpl(Class<EnterpriseTipDetails> entity) {
        super(entity);
    }
}
