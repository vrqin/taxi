package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.MileageIncomeAnalysisDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface MileageIncomeAnalysisDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public MileageIncomeAnalysisDay findByid(Integer id);

    public void delete(Integer id);

    public void save(MileageIncomeAnalysisDay mileageIncomeAnalysisDay);

    public void saveOrUpd(MileageIncomeAnalysisDay mileageIncomeAnalysisDay);

}
