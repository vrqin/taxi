package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseTipStatis;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseTipStatisService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseTipStatis findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseTipStatis enterpriseTipStatis);

    public void saveOrUpd(EnterpriseTipStatis enterpriseTipStatis);

}
