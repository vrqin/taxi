package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.AverageDailyDriveStatisYearDao;
import com.spring.jersy.hibernate.model.entity.AverageDailyDriveStatisYear;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class AverageDailyDriveStatisYearDaoImpl extends BaseDaoImpl<AverageDailyDriveStatisYear, Integer> implements AverageDailyDriveStatisYearDao {
    public AverageDailyDriveStatisYearDaoImpl() {
        super(AverageDailyDriveStatisYear.class);
    }

    public AverageDailyDriveStatisYearDaoImpl(Class<AverageDailyDriveStatisYear> entity) {
        super(entity);
    }
}
