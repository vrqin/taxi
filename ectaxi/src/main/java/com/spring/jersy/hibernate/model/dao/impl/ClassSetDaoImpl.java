package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.ClassSetDao;
import com.spring.jersy.hibernate.model.entity.ClassSet;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class ClassSetDaoImpl extends BaseDaoImpl<ClassSet, Integer> implements ClassSetDao {
    public ClassSetDaoImpl() {
        super(ClassSet.class);
    }

    public ClassSetDaoImpl(Class<ClassSet> entity) {
        super(entity);
    }
}
