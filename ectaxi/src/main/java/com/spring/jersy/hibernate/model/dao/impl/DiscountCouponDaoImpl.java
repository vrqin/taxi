package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DiscountCouponDao;
import com.spring.jersy.hibernate.model.entity.DiscountCoupon;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/3/17.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DiscountCouponDaoImpl extends BaseDaoImpl<DiscountCoupon, Integer> implements DiscountCouponDao {
    public DiscountCouponDaoImpl() {
        super(DiscountCoupon.class);
    }

    public DiscountCouponDaoImpl(Class<DiscountCoupon> entity) {
        super(entity);
    }
}
