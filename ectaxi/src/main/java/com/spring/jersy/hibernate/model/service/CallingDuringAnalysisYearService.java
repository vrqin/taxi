package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CallingDuringAnalysisYear;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CallingDuringAnalysisYearService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CallingDuringAnalysisYear findByid(Integer id);

    public void delete(Integer id);

    public void save(CallingDuringAnalysisYear callingDuringAnalysisYear);

    public void saveOrUpd(CallingDuringAnalysisYear callingDuringAnalysisYear);

}
