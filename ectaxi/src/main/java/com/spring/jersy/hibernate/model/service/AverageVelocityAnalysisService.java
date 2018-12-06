package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.AverageVelocityAnalysis;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface AverageVelocityAnalysisService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public AverageVelocityAnalysis findByid(Integer id);

    public void delete(Integer id);

    public void save(AverageVelocityAnalysis averageVelocityAnalysis);

    public void saveOrUpd(AverageVelocityAnalysis averageVelocityAnalysis);

}
