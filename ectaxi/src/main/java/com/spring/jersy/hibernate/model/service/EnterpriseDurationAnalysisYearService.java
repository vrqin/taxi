package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseDurationAnalysisYear;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseDurationAnalysisYearService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseDurationAnalysisYear findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseDurationAnalysisYear enterpriseDurationAnalysisYear);

    public void saveOrUpd(EnterpriseDurationAnalysisYear enterpriseDurationAnalysisYear);

}
