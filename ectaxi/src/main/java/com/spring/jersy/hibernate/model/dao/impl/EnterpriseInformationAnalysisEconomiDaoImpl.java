package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseInformationAnalysisEconomiDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseInformationAnalysisEconomi;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseInformationAnalysisEconomiDaoImpl extends BaseDaoImpl<EnterpriseInformationAnalysisEconomi, Integer> implements EnterpriseInformationAnalysisEconomiDao {
    public EnterpriseInformationAnalysisEconomiDaoImpl() {
        super(EnterpriseInformationAnalysisEconomi.class);
    }

    public EnterpriseInformationAnalysisEconomiDaoImpl(Class<EnterpriseInformationAnalysisEconomi> entity) {
        super(entity);
    }
}
