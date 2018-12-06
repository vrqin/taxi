package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseDurationAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseDurationAnalysisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseDurationAnalysisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseDurationAnalysisMonth enterpriseDurationAnalysisMonth);

    public void saveOrUpd(EnterpriseDurationAnalysisMonth enterpriseDurationAnalysisMonth);

}
