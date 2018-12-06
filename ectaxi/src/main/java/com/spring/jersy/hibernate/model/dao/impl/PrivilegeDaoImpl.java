package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PrivilegeDao;
import com.spring.jersy.hibernate.model.entity.Privilege;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege, Integer> implements PrivilegeDao {
    public PrivilegeDaoImpl() {
        super(Privilege.class);
    }

    public PrivilegeDaoImpl(Class<Privilege> entity) {
        super(entity);
    }
}
