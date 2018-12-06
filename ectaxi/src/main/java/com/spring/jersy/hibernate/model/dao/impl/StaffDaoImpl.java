package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.StaffDao;
import com.spring.jersy.hibernate.model.entity.Staff;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class StaffDaoImpl extends BaseDaoImpl<Staff, Integer> implements StaffDao {
    public StaffDaoImpl() {
        super(Staff.class);
    }

    public StaffDaoImpl(Class<Staff> entity) {
        super(entity);
    }
}
