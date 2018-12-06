package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.NotifierPlusDao;
import com.spring.jersy.hibernate.model.entity.NotifierPlus;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class NotifierPlusDaoImpl extends BaseDaoImpl<NotifierPlus, Integer> implements NotifierPlusDao {
    public NotifierPlusDaoImpl() {
        super(NotifierPlus.class);
    }

    public NotifierPlusDaoImpl(Class<NotifierPlus> entity) {
        super(entity);
    }
}
