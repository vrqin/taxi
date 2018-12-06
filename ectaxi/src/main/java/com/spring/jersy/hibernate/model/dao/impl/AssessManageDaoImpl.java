package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.AssessManageDao;
import com.spring.jersy.hibernate.model.entity.AssessManage;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class AssessManageDaoImpl extends BaseDaoImpl<AssessManage, Integer> implements AssessManageDao {
    public AssessManageDaoImpl() {
        super(AssessManage.class);
    }

    public AssessManageDaoImpl(Class<AssessManage> entity) {
        super(entity);
    }
}
