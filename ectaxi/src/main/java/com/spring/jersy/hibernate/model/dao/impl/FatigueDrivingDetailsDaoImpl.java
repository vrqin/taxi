package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.FatigueDrivingDetailsDao;
import com.spring.jersy.hibernate.model.entity.FatigueDrivingDetails;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class FatigueDrivingDetailsDaoImpl extends BaseDaoImpl<FatigueDrivingDetails, Integer> implements FatigueDrivingDetailsDao {
    public FatigueDrivingDetailsDaoImpl() {
        super(FatigueDrivingDetails.class);
    }

    public FatigueDrivingDetailsDaoImpl(Class<FatigueDrivingDetails> entity) {
        super(entity);
    }
}
