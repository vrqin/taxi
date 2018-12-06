package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.TypevalueDao;
import com.spring.jersy.hibernate.model.entity.TypeValue;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class TypevalueDaoImpl extends BaseDaoImpl<TypeValue, Integer> implements TypevalueDao {
    public TypevalueDaoImpl() {
        super(TypeValue.class);
    }

    public TypevalueDaoImpl(Class<TypeValue> entity) {
        super(entity);
    }
}
