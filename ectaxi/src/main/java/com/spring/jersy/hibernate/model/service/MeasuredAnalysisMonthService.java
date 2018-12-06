package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.MeasuredAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface MeasuredAnalysisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public MeasuredAnalysisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(MeasuredAnalysisMonth measuredAnalysisMonth);

    public void saveOrUpd(MeasuredAnalysisMonth measuredAnalysisMonth);

}
