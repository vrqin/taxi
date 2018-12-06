package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseInformationAnalysisStaffDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseInformationAnalysisStaff;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseInformationAnalysisStaffDaoImpl extends BaseDaoImpl<EnterpriseInformationAnalysisStaff, Integer> implements EnterpriseInformationAnalysisStaffDao {
    public EnterpriseInformationAnalysisStaffDaoImpl() {
        super(EnterpriseInformationAnalysisStaff.class);
    }

    public EnterpriseInformationAnalysisStaffDaoImpl(Class<EnterpriseInformationAnalysisStaff> entity) {
        super(entity);
    }
}
