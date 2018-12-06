package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OperateRangePeakDao;
import com.spring.jersy.hibernate.model.entity.OperateRangePeak;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OperateRangePeakDaoImpl extends BaseDaoImpl<OperateRangePeak, Integer> implements OperateRangePeakDao {
    public OperateRangePeakDaoImpl() {
        super(OperateRangePeak.class);
    }

    public OperateRangePeakDaoImpl(Class<OperateRangePeak> entity) {
        super(entity);
    }
}
