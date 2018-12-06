package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.RemindSetDao;
import com.spring.jersy.hibernate.model.entity.RemindSet;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/9.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class RemindSetDaoImpl extends BaseDaoImpl<RemindSet, Integer> implements RemindSetDao {
    public RemindSetDaoImpl() {
        super(RemindSet.class);
    }

    public RemindSetDaoImpl(Class<RemindSet> entity) {
        super(entity);
    }
}
