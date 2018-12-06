package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.MeasuredAnalysisYear;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface MeasuredAnalysisYearService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public MeasuredAnalysisYear findByid(Integer id);

    public void delete(Integer id);

    public void save(MeasuredAnalysisYear measuredAnalysisYear);

    public void saveOrUpd(MeasuredAnalysisYear measuredAnalysisYear);

}
