package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CarMonthlyIncomeAnalysis;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CarMonthlyIncomeAnalysisService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CarMonthlyIncomeAnalysis findByid(Integer id);

    public void delete(Integer id);

    public void save(CarMonthlyIncomeAnalysis carMonthlyIncomeAnalysis);

    public void saveOrUpd(CarMonthlyIncomeAnalysis carMonthlyIncomeAnalysis);

}
