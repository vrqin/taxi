package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.IllegalNumStatisticsDao;
import com.spring.jersy.hibernate.model.entity.IllegalNumStatistics;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class IllegalNumStatisticsDaoImpl extends BaseDaoImpl<IllegalNumStatistics, Integer> implements IllegalNumStatisticsDao {
    public IllegalNumStatisticsDaoImpl() {
        super(IllegalNumStatistics.class);
    }

    public IllegalNumStatisticsDaoImpl(Class<IllegalNumStatistics> entity) {
        super(entity);
    }
}
