package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OverspeedAlarmDetailsDao;
import com.spring.jersy.hibernate.model.entity.OverspeedAlarmDetails;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OverspeedAlarmDetailsDaoImpl extends BaseDaoImpl<OverspeedAlarmDetails, Integer> implements OverspeedAlarmDetailsDao {
    public OverspeedAlarmDetailsDaoImpl() {
        super(OverspeedAlarmDetails.class);
    }

    public OverspeedAlarmDetailsDaoImpl(Class<OverspeedAlarmDetails> entity) {
        super(entity);
    }
}
