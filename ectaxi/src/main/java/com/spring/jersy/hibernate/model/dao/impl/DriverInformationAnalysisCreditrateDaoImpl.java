package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverInformationAnalysisCreditrateDao;
import com.spring.jersy.hibernate.model.entity.DriverInformationAnalysisCreditrate;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverInformationAnalysisCreditrateDaoImpl extends BaseDaoImpl<DriverInformationAnalysisCreditrate, Integer> implements DriverInformationAnalysisCreditrateDao {
    public DriverInformationAnalysisCreditrateDaoImpl() {
        super(DriverInformationAnalysisCreditrate.class);
    }

    public DriverInformationAnalysisCreditrateDaoImpl(Class<DriverInformationAnalysisCreditrate> entity) {
        super(entity);
    }
}
