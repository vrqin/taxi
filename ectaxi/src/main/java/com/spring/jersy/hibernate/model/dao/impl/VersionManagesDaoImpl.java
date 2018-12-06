package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.VersionManagesDao;
import com.spring.jersy.hibernate.model.entity.VersionManages;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class VersionManagesDaoImpl extends BaseDaoImpl<VersionManages, Integer> implements VersionManagesDao {
    public VersionManagesDaoImpl() {
        super(VersionManages.class);
    }

    public VersionManagesDaoImpl(Class<VersionManages> entity) {
        super(entity);
    }
}
