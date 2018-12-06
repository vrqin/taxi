package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.PeaktimeIncomeAnalysisDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface PeaktimeIncomeAnalysisDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public PeaktimeIncomeAnalysisDay findByid(Integer id);

    public void delete(Integer id);

    public void save(PeaktimeIncomeAnalysisDay peaktimeIncomeAnalysisDay);

    public void saveOrUpd(PeaktimeIncomeAnalysisDay peaktimeIncomeAnalysisDay);

}
