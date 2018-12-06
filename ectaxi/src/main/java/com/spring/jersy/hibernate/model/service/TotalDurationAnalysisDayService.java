package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.TotalDurationAnalysisDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface TotalDurationAnalysisDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public TotalDurationAnalysisDay findByid(Integer id);

    public void delete(Integer id);

    public void save(TotalDurationAnalysisDay totalDurationAnalysisDay);

    public void saveOrUpd(TotalDurationAnalysisDay totalDurationAnalysisDay);

}
