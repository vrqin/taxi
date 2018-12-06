package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.RoleDao;
import com.spring.jersy.hibernate.model.entity.Role;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role, Integer> implements RoleDao {
    public RoleDaoImpl() {
        super(Role.class);
    }

    public RoleDaoImpl(Class<Role> entity) {
        super(entity);
    }
}
