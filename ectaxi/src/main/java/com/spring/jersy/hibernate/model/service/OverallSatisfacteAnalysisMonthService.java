package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.OverallSatisfacteAnalysisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface OverallSatisfacteAnalysisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public OverallSatisfacteAnalysisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(OverallSatisfacteAnalysisMonth overallSatisfacteAnalysisMonth);

    public void saveOrUpd(OverallSatisfacteAnalysisMonth overallSatisfacteAnalysisMonth);

}
