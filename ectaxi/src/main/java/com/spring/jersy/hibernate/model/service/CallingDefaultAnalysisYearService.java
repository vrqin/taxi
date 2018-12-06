package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CallingDefaultAnalysisYear;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CallingDefaultAnalysisYearService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CallingDefaultAnalysisYear findByid(Integer id);

    public void delete(Integer id);

    public void save(CallingDefaultAnalysisYear callingDefaultAnalysisYear);

    public void saveOrUpd(CallingDefaultAnalysisYear callingDefaultAnalysisYear);

}
