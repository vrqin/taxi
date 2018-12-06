package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OperatDetailsDao;
import com.spring.jersy.hibernate.model.entity.OperatDetails;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OperatDetailsDaoImpl extends BaseDaoImpl<OperatDetails, Integer> implements OperatDetailsDao {
    public OperatDetailsDaoImpl() {
        super(OperatDetails.class);
    }

    public OperatDetailsDaoImpl(Class<OperatDetails> entity) {
        super(entity);
    }
}
