package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.IllegalTrendStatisticsYear;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface IllegalTrendStatisticsYearService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public IllegalTrendStatisticsYear findByid(Integer id);

    public void delete(Integer id);

    public void save(IllegalTrendStatisticsYear illegalTrendStatisticsYear);

    public void saveOrUpd(IllegalTrendStatisticsYear illegalTrendStatisticsYear);

}
