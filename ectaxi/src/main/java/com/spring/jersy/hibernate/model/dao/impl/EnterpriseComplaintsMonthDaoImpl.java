package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseComplaintsMonthDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseComplaintsMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseComplaintsMonthDaoImpl extends BaseDaoImpl<EnterpriseComplaintsMonth, Integer> implements EnterpriseComplaintsMonthDao {
    public EnterpriseComplaintsMonthDaoImpl() {
        super(EnterpriseComplaintsMonth.class);
    }

    public EnterpriseComplaintsMonthDaoImpl(Class<EnterpriseComplaintsMonth> entity) {
        super(entity);
    }
}
