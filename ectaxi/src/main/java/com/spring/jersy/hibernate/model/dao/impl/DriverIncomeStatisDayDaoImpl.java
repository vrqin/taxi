package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverIncomeStatisDayDao;
import com.spring.jersy.hibernate.model.entity.DriverIncomeStatisDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverIncomeStatisDayDaoImpl extends BaseDaoImpl<DriverIncomeStatisDay, Integer> implements DriverIncomeStatisDayDao {
    public DriverIncomeStatisDayDaoImpl() {
        super(DriverIncomeStatisDay.class);
    }

    public DriverIncomeStatisDayDaoImpl(Class<DriverIncomeStatisDay> entity) {
        super(entity);
    }
}
