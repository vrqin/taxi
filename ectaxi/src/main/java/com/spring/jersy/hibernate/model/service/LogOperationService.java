package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.LogOperation;
import com.spring.jersy.hibernate.publics.util.PageList;

/**
 * Created by Administrator on 2016/9/12.
 */
public interface LogOperationService {
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer clientid) throws Exception;

    public LogOperation findByid(Integer id);

    public void save(LogOperation logOperation);

    public void saveOrUpd(LogOperation logOperation);

    public void savelogOperation(String token, int type, String content, Integer clientid);


}
