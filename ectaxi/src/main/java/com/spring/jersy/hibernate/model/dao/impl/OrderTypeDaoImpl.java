package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OrderTypeDao;
import com.spring.jersy.hibernate.model.entity.OrderType;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/7/19.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OrderTypeDaoImpl extends BaseDaoImpl<OrderType, Integer> implements OrderTypeDao {
    public OrderTypeDaoImpl() {
        super(OrderType.class);
    }

    public OrderTypeDaoImpl(Class<OrderType> entity) {
        super(entity);
    }
}
