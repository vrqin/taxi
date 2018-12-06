package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CarInformationAnalysisFueltypeDao;
import com.spring.jersy.hibernate.model.entity.CarInformationAnalysisFueltype;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CarInformationAnalysisFueltypeDaoImpl extends BaseDaoImpl<CarInformationAnalysisFueltype, Integer> implements CarInformationAnalysisFueltypeDao {
    public CarInformationAnalysisFueltypeDaoImpl() {
        super(CarInformationAnalysisFueltype.class);
    }

    public CarInformationAnalysisFueltypeDaoImpl(Class<CarInformationAnalysisFueltype> entity) {
        super(entity);
    }
}
