package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseSatisfacteStaffDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteStaff;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseSatisfacteStaffDaoImpl extends BaseDaoImpl<EnterpriseSatisfacteStaff, Integer> implements EnterpriseSatisfacteStaffDao {
    public EnterpriseSatisfacteStaffDaoImpl() {
        super(EnterpriseSatisfacteStaff.class);
    }

    public EnterpriseSatisfacteStaffDaoImpl(Class<EnterpriseSatisfacteStaff> entity) {
        super(entity);
    }
}
