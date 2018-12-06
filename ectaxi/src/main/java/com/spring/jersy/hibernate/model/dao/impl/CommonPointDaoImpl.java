package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CommonPointDao;
import com.spring.jersy.hibernate.model.entity.CommonPoint;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/9.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CommonPointDaoImpl extends BaseDaoImpl<CommonPoint, Integer> implements CommonPointDao {
    public CommonPointDaoImpl() {
        super(CommonPoint.class);
    }

    public CommonPointDaoImpl(Class<CommonPoint> entity) {
        super(entity);
    }
}
