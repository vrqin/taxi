package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OverspeedAalarmStatisDao;
import com.spring.jersy.hibernate.model.entity.OverspeedAalarmStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/9.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OverspeedAalarmStatisDaoImpl extends BaseDaoImpl<OverspeedAalarmStatis, Integer> implements OverspeedAalarmStatisDao {
    public OverspeedAalarmStatisDaoImpl() {
        super(OverspeedAalarmStatis.class);
    }

    public OverspeedAalarmStatisDaoImpl(Class<OverspeedAalarmStatis> entity) {
        super(entity);
    }
}
