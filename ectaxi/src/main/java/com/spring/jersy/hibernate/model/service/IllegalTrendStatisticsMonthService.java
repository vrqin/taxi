package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.IllegalTrendStatisticsMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface IllegalTrendStatisticsMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public IllegalTrendStatisticsMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(IllegalTrendStatisticsMonth illegalTrendStatisticsMonth);

    public void saveOrUpd(IllegalTrendStatisticsMonth illegalTrendStatisticsMonth);

}
