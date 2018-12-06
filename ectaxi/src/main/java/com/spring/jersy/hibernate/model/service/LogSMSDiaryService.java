package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.LogSMSDiary;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */
public interface LogSMSDiaryService {
    public List<LogSMSDiary> findList(String sort, String order, String key, String begintime, String endtime, Byte status, Integer clientid) throws Exception;

    public PageList findPageList(int page, int rows, String sort, String order, String key, String begintime, String endtime, Byte status, Integer clientid) throws Exception;

    public LogSMSDiary findByid(Integer id);

    public void save(LogSMSDiary logSMSDiary);

    public void saveOrUpd(LogSMSDiary logSMSDiary);

}
