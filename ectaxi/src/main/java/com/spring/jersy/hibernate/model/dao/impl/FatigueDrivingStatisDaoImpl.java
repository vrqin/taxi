package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.FatigueDrivingStatisDao;
import com.spring.jersy.hibernate.model.entity.FatigueDrivingStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class FatigueDrivingStatisDaoImpl extends BaseDaoImpl<FatigueDrivingStatis, Integer> implements FatigueDrivingStatisDao {
    public FatigueDrivingStatisDaoImpl() {
        super(FatigueDrivingStatis.class);
    }

    public FatigueDrivingStatisDaoImpl(Class<FatigueDrivingStatis> entity) {
        super(entity);
    }
}
