package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CallingPeakAnalyzedDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CallingPeakAnalyzedDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CallingPeakAnalyzedDay findByid(Integer id);

    public void delete(Integer id);

    public void save(CallingPeakAnalyzedDay callingPeakAnalyzedDay);

    public void saveOrUpd(CallingPeakAnalyzedDay callingPeakAnalyzedDay);

}
