package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OverspeedAlarmStatisDao;
import com.spring.jersy.hibernate.model.entity.OverspeedAlarmStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OverspeedAlarmStatisDaoImpl extends BaseDaoImpl<OverspeedAlarmStatis, Integer> implements OverspeedAlarmStatisDao {
    public OverspeedAlarmStatisDaoImpl() {
        super(OverspeedAlarmStatis.class);
    }

    public OverspeedAlarmStatisDaoImpl(Class<OverspeedAlarmStatis> entity) {
        super(entity);
    }
}
