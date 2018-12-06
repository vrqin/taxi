package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CarInformationAnalysisModelsDao;
import com.spring.jersy.hibernate.model.entity.CarInformationAnalysisModels;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CarInformationAnalysisModelsDaoImpl extends BaseDaoImpl<CarInformationAnalysisModels, Integer> implements CarInformationAnalysisModelsDao {
    public CarInformationAnalysisModelsDaoImpl() {
        super(CarInformationAnalysisModels.class);
    }

    public CarInformationAnalysisModelsDaoImpl(Class<CarInformationAnalysisModels> entity) {
        super(entity);
    }
}
