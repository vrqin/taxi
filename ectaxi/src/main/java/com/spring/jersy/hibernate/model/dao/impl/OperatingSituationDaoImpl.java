package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.OperatingSituationDao;
import com.spring.jersy.hibernate.model.entity.OperatingSituation;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class OperatingSituationDaoImpl extends BaseDaoImpl<OperatingSituation, Integer> implements OperatingSituationDao {
    public OperatingSituationDaoImpl() {
        super(OperatingSituation.class);
    }

    public OperatingSituationDaoImpl(Class<OperatingSituation> entity) {
        super(entity);
    }
}
