package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DirverRegDao;
import com.spring.jersy.hibernate.model.entity.DriverReg;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DirverRegDaoImpl extends BaseDaoImpl<DriverReg, Integer> implements DirverRegDao {
    public DirverRegDaoImpl() {
        super(DriverReg.class);
    }

    public DirverRegDaoImpl(Class<DriverReg> entity) {
        super(entity);
    }
}
