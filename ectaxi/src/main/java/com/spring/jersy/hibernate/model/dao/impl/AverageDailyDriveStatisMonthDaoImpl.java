package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.AverageDailyDriveStatisMonthDao;
import com.spring.jersy.hibernate.model.entity.AverageDailyDriveStatisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class AverageDailyDriveStatisMonthDaoImpl extends BaseDaoImpl<AverageDailyDriveStatisMonth, Integer> implements AverageDailyDriveStatisMonthDao {
    public AverageDailyDriveStatisMonthDaoImpl() {
        super(AverageDailyDriveStatisMonth.class);
    }

    public AverageDailyDriveStatisMonthDaoImpl(Class<AverageDailyDriveStatisMonth> entity) {
        super(entity);
    }
}
