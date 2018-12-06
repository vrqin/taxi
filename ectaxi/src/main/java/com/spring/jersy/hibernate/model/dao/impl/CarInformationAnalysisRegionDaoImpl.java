package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CarInformationAnalysisRegionDao;
import com.spring.jersy.hibernate.model.entity.CarInformationAnalysisRegion;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CarInformationAnalysisRegionDaoImpl extends BaseDaoImpl<CarInformationAnalysisRegion, Integer> implements CarInformationAnalysisRegionDao {
    public CarInformationAnalysisRegionDaoImpl() {
        super(CarInformationAnalysisRegion.class);
    }

    public CarInformationAnalysisRegionDaoImpl(Class<CarInformationAnalysisRegion> entity) {
        super(entity);
    }
}
