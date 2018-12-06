package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EmergencyAlarmDetailsDao;
import com.spring.jersy.hibernate.model.entity.EmergencyAlarmDetails;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EmergencyAlarmDetailsDaoImpl extends BaseDaoImpl<EmergencyAlarmDetails, Integer> implements EmergencyAlarmDetailsDao {
    public EmergencyAlarmDetailsDaoImpl() {
        super(EmergencyAlarmDetails.class);
    }

    public EmergencyAlarmDetailsDaoImpl(Class<EmergencyAlarmDetails> entity) {
        super(entity);
    }
}
