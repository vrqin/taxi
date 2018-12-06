package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PassengerTopupStatisticsDayDao;
import com.spring.jersy.hibernate.model.entity.PassengerTopupStatisticsDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PassengerTopupStatisticsDayDaoImpl extends BaseDaoImpl<PassengerTopupStatisticsDay, Integer> implements PassengerTopupStatisticsDayDao {
    public PassengerTopupStatisticsDayDaoImpl() {
        super(PassengerTopupStatisticsDay.class);
    }

    public PassengerTopupStatisticsDayDaoImpl(Class<PassengerTopupStatisticsDay> entity) {
        super(entity);
    }
}
