package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CallBussStatDao;
import com.spring.jersy.hibernate.model.entity.CallBussStat;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/19.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CallBussStatDaoImpl extends BaseDaoImpl<CallBussStat, Integer> implements CallBussStatDao {

    public CallBussStatDaoImpl() {
        super(CallBussStat.class);
    }

    public CallBussStatDaoImpl(Class<CallBussStat> entity) {
        super(entity);
    }
}
