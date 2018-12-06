package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverDao;
import com.spring.jersy.hibernate.model.entity.Driver;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/3/17.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverDaoImpl extends BaseDaoImpl<Driver, Integer> implements DriverDao {
    public DriverDaoImpl() {
        super(Driver.class);
    }

    public DriverDaoImpl(Class<Driver> entity) {
        super(entity);
    }
}
