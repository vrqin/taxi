package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.LostAcceptDao;
import com.spring.jersy.hibernate.model.entity.LostAccept;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/9.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class LostAcceptDaoImpl extends BaseDaoImpl<LostAccept, Integer> implements LostAcceptDao {
    public LostAcceptDaoImpl() {
        super(LostAccept.class);
    }

    public LostAcceptDaoImpl(Class<LostAccept> entity) {
        super(entity);
    }
}
