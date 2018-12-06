package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverIncomeRankingDao;
import com.spring.jersy.hibernate.model.entity.DriverIncomeRanking;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverIncomeRankingDaoImpl extends BaseDaoImpl<DriverIncomeRanking, Integer> implements DriverIncomeRankingDao {
    public DriverIncomeRankingDaoImpl() {
        super(DriverIncomeRanking.class);
    }

    public DriverIncomeRankingDaoImpl(Class<DriverIncomeRanking> entity) {
        super(entity);
    }
}
