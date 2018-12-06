package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PassPayDetailsDao;
import com.spring.jersy.hibernate.model.entity.PassPayDetails;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PassPayDetailsDaoImpl extends BaseDaoImpl<PassPayDetails, Integer> implements PassPayDetailsDao {
    public PassPayDetailsDaoImpl() {
        super(PassPayDetails.class);
    }

    public PassPayDetailsDaoImpl(Class<PassPayDetails> entity) {
        super(entity);
    }
}
