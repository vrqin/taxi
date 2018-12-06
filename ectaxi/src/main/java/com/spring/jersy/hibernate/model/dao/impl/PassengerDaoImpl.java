package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PassengerDao;
import com.spring.jersy.hibernate.model.entity.Passenger;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/3/17.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PassengerDaoImpl extends BaseDaoImpl<Passenger, Integer> implements PassengerDao {
    public PassengerDaoImpl() {
        super(Passenger.class);
    }

    public PassengerDaoImpl(Class<Passenger> entity) {
        super(entity);
    }
}
