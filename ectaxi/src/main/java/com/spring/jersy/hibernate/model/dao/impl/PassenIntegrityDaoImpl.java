package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PassenIntegrityDao;
import com.spring.jersy.hibernate.model.entity.PassenIntegrity;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/10.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PassenIntegrityDaoImpl extends BaseDaoImpl<PassenIntegrity, Integer> implements PassenIntegrityDao {
    public PassenIntegrityDaoImpl() {
        super(PassenIntegrity.class);
    }

    public PassenIntegrityDaoImpl(Class<PassenIntegrity> entity) {
        super(entity);
    }
}
