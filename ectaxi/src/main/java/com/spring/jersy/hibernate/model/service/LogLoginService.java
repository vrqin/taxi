package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.LogLogin;
import com.spring.jersy.hibernate.publics.util.PageList;

/**
 * Created by Administrator on 2016/9/12.
 */
public interface LogLoginService {
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer type, Integer clientid) throws Exception;

    public LogLogin findByid(Integer id);

    public void save(LogLogin logLogin);

    public void saveOrUpd(LogLogin logLogin);

}
