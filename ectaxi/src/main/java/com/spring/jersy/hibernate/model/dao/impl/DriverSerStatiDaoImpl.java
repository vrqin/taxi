package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverSerStatiDao;
import com.spring.jersy.hibernate.model.entity.DriverSerStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/9.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverSerStatiDaoImpl extends BaseDaoImpl<DriverSerStatis, Integer> implements DriverSerStatiDao {
    public DriverSerStatiDaoImpl() {
        super(DriverSerStatis.class);
    }

    public DriverSerStatiDaoImpl(Class<DriverSerStatis> entity) {
        super(entity);
    }
}
