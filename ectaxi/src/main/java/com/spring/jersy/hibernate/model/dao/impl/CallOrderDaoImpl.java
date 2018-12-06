package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CallOrderDao;
import com.spring.jersy.hibernate.model.entity.CallOrder;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/3/17.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CallOrderDaoImpl extends BaseDaoImpl<CallOrder, Integer> implements CallOrderDao {
    public CallOrderDaoImpl() {
        super(CallOrder.class);
    }

    public CallOrderDaoImpl(Class<CallOrder> entity) {
        super(entity);
    }
}
