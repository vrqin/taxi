package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PassengerTopupStatisticsMonthDao;
import com.spring.jersy.hibernate.model.entity.PassengerTopupStatisticsMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PassengerTopupStatisticsMonthDaoImpl extends BaseDaoImpl<PassengerTopupStatisticsMonth, Integer> implements PassengerTopupStatisticsMonthDao {
    public PassengerTopupStatisticsMonthDaoImpl() {
        super(PassengerTopupStatisticsMonth.class);
    }

    public PassengerTopupStatisticsMonthDaoImpl(Class<PassengerTopupStatisticsMonth> entity) {
        super(entity);
    }
}
