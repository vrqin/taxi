package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.entity.WorkRecords;
import com.spring.jersy.hibernate.model.service.WorkRecordsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
@Service
public class WorkRecordsServiceImpl implements WorkRecordsService {

    @Override
    public List<WorkRecords> findList(String sort, String order, String key, String begintime, String endtime) throws Exception {
        return null;
    }

    @Override
    public WorkRecords findByid(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void save(WorkRecords workRecords) {

    }

    @Override
    public void saveOrUpd(WorkRecords workRecords) {

    }
}
