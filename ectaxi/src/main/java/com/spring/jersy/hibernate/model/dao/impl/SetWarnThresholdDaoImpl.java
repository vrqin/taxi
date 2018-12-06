package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.SetWarnThresholdDao;
import com.spring.jersy.hibernate.model.entity.SetWarnThreshold;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class SetWarnThresholdDaoImpl extends BaseDaoImpl<SetWarnThreshold, Integer> implements SetWarnThresholdDao {
    public SetWarnThresholdDaoImpl() {
        super(SetWarnThreshold.class);
    }

    public SetWarnThresholdDaoImpl(Class<SetWarnThreshold> entity) {
        super(entity);
    }
}
