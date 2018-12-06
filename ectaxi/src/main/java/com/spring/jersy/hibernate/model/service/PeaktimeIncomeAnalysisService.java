package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.PeaktimeIncomeAnalysis;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface PeaktimeIncomeAnalysisService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public PeaktimeIncomeAnalysis findByid(Integer id);

    public void delete(Integer id);

    public void save(PeaktimeIncomeAnalysis peaktimeIncomeAnalysis);

    public void saveOrUpd(PeaktimeIncomeAnalysis peaktimeIncomeAnalysis);

}
