package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CorporateIncomeRankingDayDao;
import com.spring.jersy.hibernate.model.entity.CorporateIncomeRankingDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CorporateIncomeRankingDayDaoImpl extends BaseDaoImpl<CorporateIncomeRankingDay, Integer> implements CorporateIncomeRankingDayDao {
    public CorporateIncomeRankingDayDaoImpl() {
        super(CorporateIncomeRankingDay.class);
    }

    public CorporateIncomeRankingDayDaoImpl(Class<CorporateIncomeRankingDay> entity) {
        super(entity);
    }
}
