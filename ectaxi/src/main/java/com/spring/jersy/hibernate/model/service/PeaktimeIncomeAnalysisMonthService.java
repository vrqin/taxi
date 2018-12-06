package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.PeaktimeIncomeAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface PeaktimeIncomeAnalysisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public PeaktimeIncomeAnalysisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(PeaktimeIncomeAnalysisMonth peaktimeIncomeAnalysisMonth);

    public void saveOrUpd(PeaktimeIncomeAnalysisMonth peaktimeIncomeAnalysisMonth);

}
