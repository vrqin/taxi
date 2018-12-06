package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.ResourceDao;
import com.spring.jersy.hibernate.model.entity.Resource;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class ResourceDaoImpl extends BaseDaoImpl<Resource, Integer> implements ResourceDao {
    public ResourceDaoImpl() {
        super(Resource.class);
    }

    public ResourceDaoImpl(Class<Resource> entity) {
        super(entity);
    }
}
