package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverInformationAnalysisRegionDao;
import com.spring.jersy.hibernate.model.entity.DriverInformationAnalysisRegion;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverInformationAnalysisRegionDaoImpl extends BaseDaoImpl<DriverInformationAnalysisRegion, Integer> implements DriverInformationAnalysisRegionDao {
    public DriverInformationAnalysisRegionDaoImpl() {
        super(DriverInformationAnalysisRegion.class);
    }

    public DriverInformationAnalysisRegionDaoImpl(Class<DriverInformationAnalysisRegion> entity) {
        super(entity);
    }
}
