package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DefaultPositionDao;
import com.spring.jersy.hibernate.model.entity.DefaultPosition;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/7/6.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DefaultPositionDaoImpl extends BaseDaoImpl<DefaultPosition, Integer> implements DefaultPositionDao {
    public DefaultPositionDaoImpl() {
        super(DefaultPosition.class);
    }

    public DefaultPositionDaoImpl(Class<DefaultPosition> entity) {
        super(entity);
    }
}
