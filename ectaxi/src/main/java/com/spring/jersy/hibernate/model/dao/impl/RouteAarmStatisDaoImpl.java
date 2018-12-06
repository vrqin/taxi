package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.RouteAarmStatisDao;
import com.spring.jersy.hibernate.model.entity.RouteAarmStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/9.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class RouteAarmStatisDaoImpl extends BaseDaoImpl<RouteAarmStatis, Integer> implements RouteAarmStatisDao {
    public RouteAarmStatisDaoImpl() {
        super(RouteAarmStatis.class);
    }

    public RouteAarmStatisDaoImpl(Class<RouteAarmStatis> entity) {
        super(entity);
    }
}
