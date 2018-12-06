package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.IllegalTrendStatisticsYearDao;
import com.spring.jersy.hibernate.model.entity.IllegalTrendStatisticsYear;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class IllegalTrendStatisticsYearDaoImpl extends BaseDaoImpl<IllegalTrendStatisticsYear, Integer> implements IllegalTrendStatisticsYearDao {
    public IllegalTrendStatisticsYearDaoImpl() {
        super(IllegalTrendStatisticsYear.class);
    }

    public IllegalTrendStatisticsYearDaoImpl(Class<IllegalTrendStatisticsYear> entity) {
        super(entity);
    }
}
