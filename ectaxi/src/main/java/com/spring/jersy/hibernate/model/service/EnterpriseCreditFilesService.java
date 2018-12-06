package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseCreditFiles;

import java.util.List;

public interface EnterpriseCreditFilesService {

    public List<EnterpriseCreditFiles> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

    public EnterpriseCreditFiles findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseCreditFiles enterpriseCreditFiles);

    public void saveOrUpd(EnterpriseCreditFiles enterpriseCreditFiles);

}
