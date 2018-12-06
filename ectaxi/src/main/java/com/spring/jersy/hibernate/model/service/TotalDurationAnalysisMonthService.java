package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.TotalDurationAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface TotalDurationAnalysisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public TotalDurationAnalysisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(TotalDurationAnalysisMonth totalDurationAnalysisMonth);

    public void saveOrUpd(TotalDurationAnalysisMonth totalDurationAnalysisMonth);

}
