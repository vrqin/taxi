package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.RegionalPoliceStatisDao;
import com.spring.jersy.hibernate.model.entity.RegionalPoliceStatis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class RegionalPoliceStatisDaoImpl extends BaseDaoImpl<RegionalPoliceStatis, Integer> implements RegionalPoliceStatisDao {
    public RegionalPoliceStatisDaoImpl() {
        super(RegionalPoliceStatis.class);
    }

    public RegionalPoliceStatisDaoImpl(Class<RegionalPoliceStatis> entity) {
        super(entity);
    }
}
