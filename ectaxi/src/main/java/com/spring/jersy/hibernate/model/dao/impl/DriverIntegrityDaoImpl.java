package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverIntegrityDao;
import com.spring.jersy.hibernate.model.entity.DriverIntegrity;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/10.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverIntegrityDaoImpl extends BaseDaoImpl<DriverIntegrity, Integer> implements DriverIntegrityDao {
    public DriverIntegrityDaoImpl() {
        super(DriverIntegrity.class);
    }

    public DriverIntegrityDaoImpl(Class<DriverIntegrity> entity) {
        super(entity);
    }
}
