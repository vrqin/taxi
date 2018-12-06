package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverIncomeRankingDayDao;
import com.spring.jersy.hibernate.model.entity.DriverIncomeRankingDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverIncomeRankingDayDaoImpl extends BaseDaoImpl<DriverIncomeRankingDay, Integer> implements DriverIncomeRankingDayDao {
    public DriverIncomeRankingDayDaoImpl() {
        super(DriverIncomeRankingDay.class);
    }

    public DriverIncomeRankingDayDaoImpl(Class<DriverIncomeRankingDay> entity) {
        super(entity);
    }
}
