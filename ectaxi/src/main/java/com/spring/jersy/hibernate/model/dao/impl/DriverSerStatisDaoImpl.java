package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverSerStatisDao;
import com.spring.jersy.hibernate.model.entity.DriverSerStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverSerStatisDaoImpl extends BaseDaoImpl<DriverSerStatis, Integer> implements DriverSerStatisDao {
    public DriverSerStatisDaoImpl() {
        super(DriverSerStatis.class);
    }

    public DriverSerStatisDaoImpl(Class<DriverSerStatis> entity) {
        super(entity);
    }
}
