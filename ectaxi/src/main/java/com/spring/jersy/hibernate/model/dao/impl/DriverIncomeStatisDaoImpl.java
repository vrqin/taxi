package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverIncomeStatisDao;
import com.spring.jersy.hibernate.model.entity.DriverIncomeStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverIncomeStatisDaoImpl extends BaseDaoImpl<DriverIncomeStatis, Integer> implements DriverIncomeStatisDao {
    public DriverIncomeStatisDaoImpl() {
        super(DriverIncomeStatis.class);
    }

    public DriverIncomeStatisDaoImpl(Class<DriverIncomeStatis> entity) {
        super(entity);
    }
}
