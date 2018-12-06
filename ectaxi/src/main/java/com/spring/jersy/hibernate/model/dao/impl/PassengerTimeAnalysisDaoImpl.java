package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PassengerTimeAnalysisDao;
import com.spring.jersy.hibernate.model.entity.PassengerTimeAnalysis;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PassengerTimeAnalysisDaoImpl extends BaseDaoImpl<PassengerTimeAnalysis, Integer> implements PassengerTimeAnalysisDao {
    public PassengerTimeAnalysisDaoImpl() {
        super(PassengerTimeAnalysis.class);
    }

    public PassengerTimeAnalysisDaoImpl(Class<PassengerTimeAnalysis> entity) {
        super(entity);
    }
}
