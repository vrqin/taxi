package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.RouteAlarmDetailsDao;
import com.spring.jersy.hibernate.model.entity.RouteAlarmDetails;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class RouteAlarmDetailsDaoImpl extends BaseDaoImpl<RouteAlarmDetails, Integer> implements RouteAlarmDetailsDao {
    public RouteAlarmDetailsDaoImpl() {
        super(RouteAlarmDetails.class);
    }

    public RouteAlarmDetailsDaoImpl(Class<RouteAlarmDetails> entity) {
        super(entity);
    }
}
