package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseInformationAnalysisFundsDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseInformationAnalysisFunds;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseInformationAnalysisFundsDaoImpl extends BaseDaoImpl<EnterpriseInformationAnalysisFunds, Integer> implements EnterpriseInformationAnalysisFundsDao {
    public EnterpriseInformationAnalysisFundsDaoImpl() {
        super(EnterpriseInformationAnalysisFunds.class);
    }

    public EnterpriseInformationAnalysisFundsDaoImpl(Class<EnterpriseInformationAnalysisFunds> entity) {
        super(entity);
    }
}
