package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.SeatsDao;
import com.spring.jersy.hibernate.model.entity.Seats;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/9.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class SeatsDaoImpl extends BaseDaoImpl<Seats, Integer> implements SeatsDao {
    public SeatsDaoImpl() {
        super(Seats.class);
    }

    public SeatsDaoImpl(Class<Seats> entity) {
        super(entity);
    }
}
