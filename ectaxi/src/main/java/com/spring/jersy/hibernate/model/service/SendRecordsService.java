package com.spring.jersy.hibernate.model.service;


import com.spring.jersy.hibernate.model.entity.SendRecords;

import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public interface SendRecordsService {

    public List<SendRecords> findAllList();

    public List<SendRecords> findListByorderid(String ordernum);

    public SendRecords findByid(Integer id);

    public void delete(Integer id);

    public void save(SendRecords sendRecords);

    public void saveOrUpd(SendRecords sendRecords);

    public List<SendRecords> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

}
