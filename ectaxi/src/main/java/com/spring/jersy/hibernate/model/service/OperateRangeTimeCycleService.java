package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.OperateRangeTimeCycle;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface OperateRangeTimeCycleService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public OperateRangeTimeCycle findByid(Integer id);

    public void delete(Integer id);

    public void save(OperateRangeTimeCycle operateRangeTimeCycle);

    public void saveOrUpd(OperateRangeTimeCycle operateRangeTimeCycle);

}
