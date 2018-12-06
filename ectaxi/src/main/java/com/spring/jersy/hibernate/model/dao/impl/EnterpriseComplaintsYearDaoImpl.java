package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseComplaintsYearDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseComplaintsYear;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseComplaintsYearDaoImpl extends BaseDaoImpl<EnterpriseComplaintsYear, Integer> implements EnterpriseComplaintsYearDao {
    public EnterpriseComplaintsYearDaoImpl() {
        super(EnterpriseComplaintsYear.class);
    }

    public EnterpriseComplaintsYearDaoImpl(Class<EnterpriseComplaintsYear> entity) {
        super(entity);
    }
}
