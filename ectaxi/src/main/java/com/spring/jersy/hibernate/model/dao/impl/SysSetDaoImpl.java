package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.SysSetDao;
import com.spring.jersy.hibernate.model.entity.SysSet;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/7/15.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class SysSetDaoImpl extends BaseDaoImpl<SysSet, Integer> implements SysSetDao {
    public SysSetDaoImpl() {
        super(SysSet.class);
    }

    public SysSetDaoImpl(Class<SysSet> entity) {
        super(entity);
    }
}
