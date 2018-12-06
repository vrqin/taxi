package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CarIncomeRankingDayDao;
import com.spring.jersy.hibernate.model.entity.CarIncomeRankingDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CarIncomeRankingDayDaoImpl extends BaseDaoImpl<CarIncomeRankingDay, Integer> implements CarIncomeRankingDayDao {
    public CarIncomeRankingDayDaoImpl() {
        super(CarIncomeRankingDay.class);
    }

    public CarIncomeRankingDayDaoImpl(Class<CarIncomeRankingDay> entity) {
        super(entity);
    }
}
