package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverInformationAnalysisBeendriveDao;
import com.spring.jersy.hibernate.model.entity.DriverInformationAnalysisBeendrive;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverInformationAnalysisBeendriveDaoImpl extends BaseDaoImpl<DriverInformationAnalysisBeendrive, Integer> implements DriverInformationAnalysisBeendriveDao {
    public DriverInformationAnalysisBeendriveDaoImpl() {
        super(DriverInformationAnalysisBeendrive.class);
    }

    public DriverInformationAnalysisBeendriveDaoImpl(Class<DriverInformationAnalysisBeendrive> entity) {
        super(entity);
    }
}
