package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.AverageTimeIntervalAnalysis;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface AverageTimeIntervalAnalysisService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public AverageTimeIntervalAnalysis findByid(Integer id);

    public void delete(Integer id);

    public void save(AverageTimeIntervalAnalysis averageTimeIntervalAnalysis);

    public void saveOrUpd(AverageTimeIntervalAnalysis averageTimeIntervalAnalysis);

}
