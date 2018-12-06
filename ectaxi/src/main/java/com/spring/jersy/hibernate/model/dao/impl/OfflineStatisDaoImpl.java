package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OfflineStatisDao;
import com.spring.jersy.hibernate.model.entity.OfflineStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OfflineStatisDaoImpl extends BaseDaoImpl<OfflineStatis, Integer> implements OfflineStatisDao {
    public OfflineStatisDaoImpl() {
        super(OfflineStatis.class);
    }

    public OfflineStatisDaoImpl(Class<OfflineStatis> entity) {
        super(entity);
    }
}
