package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CallingDuringAnalysisDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CallingDuringAnalysisDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CallingDuringAnalysisDay findByid(Integer id);

    public void delete(Integer id);

    public void save(CallingDuringAnalysisDay callingDuringAnalysisDay);

    public void saveOrUpd(CallingDuringAnalysisDay callingDuringAnalysisDay);

}
