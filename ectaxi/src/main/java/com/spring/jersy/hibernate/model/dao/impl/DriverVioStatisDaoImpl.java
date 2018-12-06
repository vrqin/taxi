package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverVioStatisDao;
import com.spring.jersy.hibernate.model.entity.DriverVioStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/9.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverVioStatisDaoImpl extends BaseDaoImpl<DriverVioStatis, Integer> implements DriverVioStatisDao {
    public DriverVioStatisDaoImpl() {
        super(DriverVioStatis.class);
    }

    public DriverVioStatisDaoImpl(Class<DriverVioStatis> entity) {
        super(entity);
    }
}
