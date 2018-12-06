package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseAnnualRatingDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseAnnualRating;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseAnnualRatingDaoImpl extends BaseDaoImpl<EnterpriseAnnualRating, Integer> implements EnterpriseAnnualRatingDao {
    public EnterpriseAnnualRatingDaoImpl() {
        super(EnterpriseAnnualRating.class);
    }

    public EnterpriseAnnualRatingDaoImpl(Class<EnterpriseAnnualRating> entity) {
        super(entity);
    }
}
