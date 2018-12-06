package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CallstationDao;
import com.spring.jersy.hibernate.model.entity.Callstation;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/9.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CallstationDaoImpl extends BaseDaoImpl<Callstation, Integer> implements CallstationDao {
    public CallstationDaoImpl() {
        super(Callstation.class);
    }

    public CallstationDaoImpl(Class<Callstation> entity) {
        super(entity);
    }
}
