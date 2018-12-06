package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseCreditDistribu;

import java.util.List;

public interface EnterpriseCreditDistribuService {

    public List<EnterpriseCreditDistribu> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

    public EnterpriseCreditDistribu findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseCreditDistribu enterpriseCreditDistribu);

    public void saveOrUpd(EnterpriseCreditDistribu enterpriseCreditDistribu);

}
