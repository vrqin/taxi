package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseInformationAnalysisCreditDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseInformationAnalysisCredit;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseInformationAnalysisCreditDaoImpl extends BaseDaoImpl<EnterpriseInformationAnalysisCredit, Integer> implements EnterpriseInformationAnalysisCreditDao {
    public EnterpriseInformationAnalysisCreditDaoImpl() {
        super(EnterpriseInformationAnalysisCredit.class);
    }

    public EnterpriseInformationAnalysisCreditDaoImpl(Class<EnterpriseInformationAnalysisCredit> entity) {
        super(entity);
    }
}
