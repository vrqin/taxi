package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PassengerTopupStatisticsYearDao;
import com.spring.jersy.hibernate.model.entity.PassengerTopupStatisticsYear;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PassengerTopupStatisticsYearDaoImpl extends BaseDaoImpl<PassengerTopupStatisticsYear, Integer> implements PassengerTopupStatisticsYearDao {
    public PassengerTopupStatisticsYearDaoImpl() {
        super(PassengerTopupStatisticsYear.class);
    }

    public PassengerTopupStatisticsYearDaoImpl(Class<PassengerTopupStatisticsYear> entity) {
        super(entity);
    }
}
