package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverAnnualRatingDao;
import com.spring.jersy.hibernate.model.entity.DriverAnnualRating;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverAnnualRatingDaoImpl extends BaseDaoImpl<DriverAnnualRating, Integer> implements DriverAnnualRatingDao {
    public DriverAnnualRatingDaoImpl() {
        super(DriverAnnualRating.class);
    }

    public DriverAnnualRatingDaoImpl(Class<DriverAnnualRating> entity) {
        super(entity);
    }
}
