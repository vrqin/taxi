package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DiscountPassengerDao;
import com.spring.jersy.hibernate.model.entity.DiscountPassenger;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/3/17.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DiscountPassengerDaoImpl extends BaseDaoImpl<DiscountPassenger, Integer> implements DiscountPassengerDao {
    public DiscountPassengerDaoImpl() {
        super(DiscountPassenger.class);
    }

    public DiscountPassengerDaoImpl(Class<DiscountPassenger> entity) {
        super(entity);
    }
}
