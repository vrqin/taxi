package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PassengerCheckInformationDao;
import com.spring.jersy.hibernate.model.entity.PassengerCheckInformation;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PassengerCheckInformationDaoImpl extends BaseDaoImpl<PassengerCheckInformation, Integer> implements PassengerCheckInformationDao {
    public PassengerCheckInformationDaoImpl() {
        super(PassengerCheckInformation.class);
    }

    public PassengerCheckInformationDaoImpl(Class<PassengerCheckInformation> entity) {
        super(entity);
    }
}
