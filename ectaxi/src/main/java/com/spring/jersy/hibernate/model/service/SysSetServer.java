package com.spring.jersy.hibernate.model.service;


import com.spring.jersy.hibernate.model.entity.SysSet;
import com.spring.jersy.hibernate.publics.util.PageList;

/**
 * Created by Administrator on 2016/7/15.
 */
public interface SysSetServer {

    public PageList findPageList(int page, int size, String sort, String order, String key) throws Exception;

    public void save(SysSet sysSet);

}
