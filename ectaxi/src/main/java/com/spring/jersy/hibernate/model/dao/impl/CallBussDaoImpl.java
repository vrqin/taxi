package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CallBussDao;
import com.spring.jersy.hibernate.model.entity.Callbuss;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/3/17.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CallBussDaoImpl extends BaseDaoImpl<Callbuss, Integer> implements CallBussDao {
    public CallBussDaoImpl() {
        super(Callbuss.class);
    }

    public CallBussDaoImpl(Class<Callbuss> entity) {
        super(entity);
    }
}
