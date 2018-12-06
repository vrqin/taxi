package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.LowSpeedAfterAnalysis;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface LowSpeedAfterAnalysisService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public LowSpeedAfterAnalysis findByid(Integer id);

    public void delete(Integer id);

    public void save(LowSpeedAfterAnalysis lowSpeedAfterAnalysis);

    public void saveOrUpd(LowSpeedAfterAnalysis lowSpeedAfterAnalysis);

}
