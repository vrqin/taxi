package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.publics.util.PageList;

/**
 * Created by Administrator on 2016/9/11.
 */
public interface DriverVioDeltailsService {
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer type) throws Exception;
}
