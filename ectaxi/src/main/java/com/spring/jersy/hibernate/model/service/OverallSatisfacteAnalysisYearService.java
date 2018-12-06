package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.OverallSatisfacteAnalysisYear;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface OverallSatisfacteAnalysisYearService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public OverallSatisfacteAnalysisYear findByid(Integer id);

    public void delete(Integer id);

    public void save(OverallSatisfacteAnalysisYear overallSatisfacteAnalysisYear);

    public void saveOrUpd(OverallSatisfacteAnalysisYear overallSatisfacteAnalysisYear);

}
