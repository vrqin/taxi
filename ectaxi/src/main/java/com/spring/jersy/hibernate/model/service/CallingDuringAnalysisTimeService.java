package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CallingDuringAnalysisTime;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CallingDuringAnalysisTimeService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CallingDuringAnalysisTime findByid(Integer id);

    public void delete(Integer id);

    public void save(CallingDuringAnalysisTime callingDuringAnalysisTime);

    public void saveOrUpd(CallingDuringAnalysisTime callingDuringAnalysisTime);

}
