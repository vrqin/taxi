package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CallingDuringAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CallingDuringAnalysisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CallingDuringAnalysisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(CallingDuringAnalysisMonth callingDuringAnalysisMonth);

    public void saveOrUpd(CallingDuringAnalysisMonth callingDuringAnalysisMonth);

}
