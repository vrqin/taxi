package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverComplaintsDayDao;
import com.spring.jersy.hibernate.model.entity.DriverComplaintsDay;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverComplaintsDayDaoImpl extends BaseDaoImpl<DriverComplaintsDay, Integer> implements DriverComplaintsDayDao {
    public DriverComplaintsDayDaoImpl() {
        super(DriverComplaintsDay.class);
    }

    public DriverComplaintsDayDaoImpl(Class<DriverComplaintsDay> entity) {
        super(entity);
    }
}
