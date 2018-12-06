package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseCreditStatis;

import java.util.List;

public interface EnterpriseCreditStatisService {

    public List<EnterpriseCreditStatis> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

    public EnterpriseCreditStatis findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseCreditStatis enterpriseCreditStatis);

    public void saveOrUpd(EnterpriseCreditStatis enterpriseCreditStatis);

}
