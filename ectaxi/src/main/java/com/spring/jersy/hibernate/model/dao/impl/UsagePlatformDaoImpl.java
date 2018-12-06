package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.UsagePlatformDao;
import com.spring.jersy.hibernate.model.entity.UsagePlatform;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class UsagePlatformDaoImpl extends BaseDaoImpl<UsagePlatform, Integer> implements UsagePlatformDao {
    public UsagePlatformDaoImpl() {
        super(UsagePlatform.class);
    }

    public UsagePlatformDaoImpl(Class<UsagePlatform> entity) {
        super(entity);
    }
}
