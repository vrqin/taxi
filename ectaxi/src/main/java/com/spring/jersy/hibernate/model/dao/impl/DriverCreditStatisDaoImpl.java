package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverCreditStatisDao;
import com.spring.jersy.hibernate.model.entity.DriverCreditStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverCreditStatisDaoImpl extends BaseDaoImpl<DriverCreditStatis, Integer> implements DriverCreditStatisDao {
    public DriverCreditStatisDaoImpl() {
        super(DriverCreditStatis.class);
    }

    public DriverCreditStatisDaoImpl(Class<DriverCreditStatis> entity) {
        super(entity);
    }
}
