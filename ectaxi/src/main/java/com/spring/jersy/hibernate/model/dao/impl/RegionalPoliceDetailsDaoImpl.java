package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.RegionalPoliceDetailsDao;
import com.spring.jersy.hibernate.model.entity.RegionalPoliceDetails;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class RegionalPoliceDetailsDaoImpl extends BaseDaoImpl<RegionalPoliceDetails, Integer> implements RegionalPoliceDetailsDao {
    public RegionalPoliceDetailsDaoImpl() {
        super(RegionalPoliceDetails.class);
    }

    public RegionalPoliceDetailsDaoImpl(Class<RegionalPoliceDetails> entity) {
        super(entity);
    }
}
