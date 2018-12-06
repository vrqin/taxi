package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CarInformationAnalysisValidittimeDao;
import com.spring.jersy.hibernate.model.entity.CarInformationAnalysisValidittime;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CarInformationAnalysisValidittimeDaoImpl extends BaseDaoImpl<CarInformationAnalysisValidittime, Integer> implements CarInformationAnalysisValidittimeDao {
    public CarInformationAnalysisValidittimeDaoImpl() {
        super(CarInformationAnalysisValidittime.class);
    }

    public CarInformationAnalysisValidittimeDaoImpl(Class<CarInformationAnalysisValidittime> entity) {
        super(entity);
    }
}
