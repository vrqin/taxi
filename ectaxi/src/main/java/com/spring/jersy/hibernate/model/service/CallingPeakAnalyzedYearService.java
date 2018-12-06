package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CallingPeakAnalyzedYear;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CallingPeakAnalyzedYearService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CallingPeakAnalyzedYear findByid(Integer id);

    public void delete(Integer id);

    public void save(CallingPeakAnalyzedYear callingPeakAnalyzedYear);

    public void saveOrUpd(CallingPeakAnalyzedYear callingPeakAnalyzedYear);

}
