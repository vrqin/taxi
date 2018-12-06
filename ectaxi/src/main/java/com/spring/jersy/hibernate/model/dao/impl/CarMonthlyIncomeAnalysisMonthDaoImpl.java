package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CarMonthlyIncomeAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.CarMonthlyIncomeAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CarMonthlyIncomeAnalysisMonthDaoImpl extends BaseDaoImpl<CarMonthlyIncomeAnalysisMonth, Integer> implements CarMonthlyIncomeAnalysisMonthDao {
    public CarMonthlyIncomeAnalysisMonthDaoImpl() {
        super(CarMonthlyIncomeAnalysisMonth.class);
    }

    public CarMonthlyIncomeAnalysisMonthDaoImpl(Class<CarMonthlyIncomeAnalysisMonth> entity) {
        super(entity);
    }
}
