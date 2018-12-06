package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.AverageDailyDriveStatisDayDao;
import com.spring.jersy.hibernate.model.entity.AverageDailyDriveStatisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class AverageDailyDriveStatisDayDaoImpl extends BaseDaoImpl<AverageDailyDriveStatisDay, Integer> implements AverageDailyDriveStatisDayDao {
    public AverageDailyDriveStatisDayDaoImpl() {
        super(AverageDailyDriveStatisDay.class);
    }

    public AverageDailyDriveStatisDayDaoImpl(Class<AverageDailyDriveStatisDay> entity) {
        super(entity);
    }
}
