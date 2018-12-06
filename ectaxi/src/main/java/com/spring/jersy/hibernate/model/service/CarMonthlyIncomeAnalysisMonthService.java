package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CarMonthlyIncomeAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CarMonthlyIncomeAnalysisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CarMonthlyIncomeAnalysisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(CarMonthlyIncomeAnalysisMonth carMonthlyIncomeAnalysisMonth);

    public void saveOrUpd(CarMonthlyIncomeAnalysisMonth carMonthlyIncomeAnalysisMonth);

}
