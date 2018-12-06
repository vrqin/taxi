package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverInformationAnalysisAgeDao;
import com.spring.jersy.hibernate.model.entity.DriverInformationAnalysisAge;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverInformationAnalysisAgeDaoImpl extends BaseDaoImpl<DriverInformationAnalysisAge, Integer> implements DriverInformationAnalysisAgeDao {
    public DriverInformationAnalysisAgeDaoImpl() {
        super(DriverInformationAnalysisAge.class);
    }

    public DriverInformationAnalysisAgeDaoImpl(Class<DriverInformationAnalysisAge> entity) {
        super(entity);
    }
}
