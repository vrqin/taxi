package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CallingDefaultAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CallingDefaultAnalysisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CallingDefaultAnalysisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(CallingDefaultAnalysisMonth callingDefaultAnalysisMonth);

    public void saveOrUpd(CallingDefaultAnalysisMonth callingDefaultAnalysisMonth);

}
