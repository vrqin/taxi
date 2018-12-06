package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.IllegalTrendStatisticsMonthDao;
import com.spring.jersy.hibernate.model.entity.IllegalTrendStatisticsMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class IllegalTrendStatisticsMonthDaoImpl extends BaseDaoImpl<IllegalTrendStatisticsMonth, Integer> implements IllegalTrendStatisticsMonthDao {
    public IllegalTrendStatisticsMonthDaoImpl() {
        super(IllegalTrendStatisticsMonth.class);
    }

    public IllegalTrendStatisticsMonthDaoImpl(Class<IllegalTrendStatisticsMonth> entity) {
        super(entity);
    }
}
