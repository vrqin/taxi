package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CarIncomeRankingDao;
import com.spring.jersy.hibernate.model.entity.CarIncomeRanking;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CarIncomeRankingDaoImpl extends BaseDaoImpl<CarIncomeRanking, Integer> implements CarIncomeRankingDao {
    public CarIncomeRankingDaoImpl() {
        super(CarIncomeRanking.class);
    }

    public CarIncomeRankingDaoImpl(Class<CarIncomeRanking> entity) {
        super(entity);
    }
}
