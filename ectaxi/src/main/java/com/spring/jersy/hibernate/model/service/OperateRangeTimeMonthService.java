package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.OperateRangeTimeMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface OperateRangeTimeMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public OperateRangeTimeMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(OperateRangeTimeMonth operateRangeTimeMonth);

    public void saveOrUpd(OperateRangeTimeMonth operateRangeTimeMonth);

}
