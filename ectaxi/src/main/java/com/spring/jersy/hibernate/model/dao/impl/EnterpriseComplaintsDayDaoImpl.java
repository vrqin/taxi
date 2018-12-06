package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseComplaintsDayDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseComplaintsDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseComplaintsDayDaoImpl extends BaseDaoImpl<EnterpriseComplaintsDay, Integer> implements EnterpriseComplaintsDayDao {
    public EnterpriseComplaintsDayDaoImpl() {
        super(EnterpriseComplaintsDay.class);
    }

    public EnterpriseComplaintsDayDaoImpl(Class<EnterpriseComplaintsDay> entity) {
        super(entity);
    }
}
