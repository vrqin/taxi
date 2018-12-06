package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.WorkRecords;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public interface WorkRecordsService {
    public List<WorkRecords> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

    public WorkRecords findByid(Integer id);

    public void delete(Integer id);

    public void save(WorkRecords workRecords);

    public void saveOrUpd(WorkRecords workRecords);
}
