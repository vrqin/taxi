package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.RouteAlarmStatisDao;
import com.spring.jersy.hibernate.model.entity.RouteAlarmStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class RouteAlarmStatisDaoImpl extends BaseDaoImpl<RouteAlarmStatis, Integer> implements RouteAlarmStatisDao {
    public RouteAlarmStatisDaoImpl() {
        super(RouteAlarmStatis.class);
    }

    public RouteAlarmStatisDaoImpl(Class<RouteAlarmStatis> entity) {
        super(entity);
    }
}
