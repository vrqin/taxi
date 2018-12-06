package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseSatisfacteRankDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteRank;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseSatisfacteRankDaoImpl extends BaseDaoImpl<EnterpriseSatisfacteRank, Integer> implements EnterpriseSatisfacteRankDao {
    public EnterpriseSatisfacteRankDaoImpl() {
        super(EnterpriseSatisfacteRank.class);
    }

    public EnterpriseSatisfacteRankDaoImpl(Class<EnterpriseSatisfacteRank> entity) {
        super(entity);
    }
}
