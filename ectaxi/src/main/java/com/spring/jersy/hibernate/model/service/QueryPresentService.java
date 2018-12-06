package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.QueryPresent;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface QueryPresentService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public QueryPresent findByid(Integer id);

    public void delete(Integer id);

    public void save(QueryPresent queryPresent);

    public void saveOrUpd(QueryPresent queryPresent);

}
