package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverVioDeltailsDao;
import com.spring.jersy.hibernate.model.entity.DriverVioDeltails;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/11.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverVioDeltailsDaoImpl extends BaseDaoImpl<DriverVioDeltails, Integer> implements DriverVioDeltailsDao {
    public DriverVioDeltailsDaoImpl() {
        super(DriverVioDeltails.class);
    }

    public DriverVioDeltailsDaoImpl(Class<DriverVioDeltails> entity) {
        super(entity);
    }
}
