package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseCarStatisDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseCarStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseCarStatisDaoImpl extends BaseDaoImpl<EnterpriseCarStatis, Integer> implements EnterpriseCarStatisDao {
    public EnterpriseCarStatisDaoImpl() {
        super(EnterpriseCarStatis.class);
    }

    public EnterpriseCarStatisDaoImpl(Class<EnterpriseCarStatis> entity) {
        super(entity);
    }
}
