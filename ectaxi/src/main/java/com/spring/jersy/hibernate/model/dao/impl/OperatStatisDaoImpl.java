package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OperatStatisDao;
import com.spring.jersy.hibernate.model.entity.OperatStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/10.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OperatStatisDaoImpl extends BaseDaoImpl<OperatStatis, Integer> implements OperatStatisDao {
    public OperatStatisDaoImpl() {
        super(OperatStatis.class);
    }

    public OperatStatisDaoImpl(Class<OperatStatis> entity) {
        super(entity);
    }
}
