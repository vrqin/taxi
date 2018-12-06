package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PassengerTopupDetailDao;
import com.spring.jersy.hibernate.model.entity.PassengerTopupDetail;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PassengerTopupDetailDaoImpl extends BaseDaoImpl<PassengerTopupDetail, Integer> implements PassengerTopupDetailDao {
    public PassengerTopupDetailDaoImpl() {
        super(PassengerTopupDetail.class);
    }

    public PassengerTopupDetailDaoImpl(Class<PassengerTopupDetail> entity) {
        super(entity);
    }
}
