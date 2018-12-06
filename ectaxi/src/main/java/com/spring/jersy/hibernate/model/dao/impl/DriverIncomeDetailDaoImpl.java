package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverIncomeDetailDao;
import com.spring.jersy.hibernate.model.entity.DriverIncomeDetail;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverIncomeDetailDaoImpl extends BaseDaoImpl<DriverIncomeDetail, Integer> implements DriverIncomeDetailDao {
    public DriverIncomeDetailDaoImpl() {
        super(DriverIncomeDetail.class);
    }

    public DriverIncomeDetailDaoImpl(Class<DriverIncomeDetail> entity) {
        super(entity);
    }
}
