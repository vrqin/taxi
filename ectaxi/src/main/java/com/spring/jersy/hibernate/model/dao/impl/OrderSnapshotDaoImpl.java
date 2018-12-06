package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OrderSnapshotDao;
import com.spring.jersy.hibernate.model.entity.OrderSnapshot;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/8/10.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OrderSnapshotDaoImpl extends BaseDaoImpl<OrderSnapshot, Integer> implements OrderSnapshotDao {
    public OrderSnapshotDaoImpl() {
        super(OrderSnapshot.class);
    }

    public OrderSnapshotDaoImpl(Class<OrderSnapshot> entity) {
        super(entity);
    }
}
