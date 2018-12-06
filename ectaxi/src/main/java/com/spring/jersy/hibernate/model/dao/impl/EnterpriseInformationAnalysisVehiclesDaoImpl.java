package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseInformationAnalysisVehiclesDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseInformationAnalysisVehicles;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseInformationAnalysisVehiclesDaoImpl extends BaseDaoImpl<EnterpriseInformationAnalysisVehicles, Integer> implements EnterpriseInformationAnalysisVehiclesDao {
    public EnterpriseInformationAnalysisVehiclesDaoImpl() {
        super(EnterpriseInformationAnalysisVehicles.class);
    }

    public EnterpriseInformationAnalysisVehiclesDaoImpl(Class<EnterpriseInformationAnalysisVehicles> entity) {
        super(entity);
    }
}
