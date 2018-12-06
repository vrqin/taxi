package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseDurationAnalysisDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseDurationAnalysisDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseDurationAnalysisDay findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseDurationAnalysisDay enterpriseDurationAnalysisDay);

    public void saveOrUpd(EnterpriseDurationAnalysisDay enterpriseDurationAnalysisDay);

}
