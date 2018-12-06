package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.OfflineStatis;

import java.util.List;

public interface OfflineStatisService {

    public List<OfflineStatis> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

    public OfflineStatis findByid(Integer id);

    public void delete(Integer id);

    public void save(OfflineStatis offlineStatis);

    public void saveOrUpd(OfflineStatis offlineStatis);

}
