package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CallingPeakAnalyzedMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CallingPeakAnalyzedMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CallingPeakAnalyzedMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(CallingPeakAnalyzedMonth callingPeakAnalyzedMonth);

    public void saveOrUpd(CallingPeakAnalyzedMonth callingPeakAnalyzedMonth);

}
