package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PostrackDao;
import com.spring.jersy.hibernate.model.entity.Postrack;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/3/17.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PostrackDaoImpl extends BaseDaoImpl<Postrack, Integer> implements PostrackDao {
    public PostrackDaoImpl() {
        super(Postrack.class);
    }

    public PostrackDaoImpl(Class<Postrack> entity) {
        super(entity);
    }
}
