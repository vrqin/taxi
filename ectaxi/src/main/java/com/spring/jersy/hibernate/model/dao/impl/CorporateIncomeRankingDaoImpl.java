package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CorporateIncomeRankingDao;
import com.spring.jersy.hibernate.model.entity.CorporateIncomeRanking;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CorporateIncomeRankingDaoImpl extends BaseDaoImpl<CorporateIncomeRanking, Integer> implements CorporateIncomeRankingDao {
    public CorporateIncomeRankingDaoImpl() {
        super(CorporateIncomeRanking.class);
    }

    public CorporateIncomeRankingDaoImpl(Class<CorporateIncomeRanking> entity) {
        super(entity);
    }
}
