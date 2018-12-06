package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseCorporateWrongdoing;

import java.util.List;

public interface EnterpriseCorporateWrongdoingService {

    public List<EnterpriseCorporateWrongdoing> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

    public EnterpriseCorporateWrongdoing findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseCorporateWrongdoing enterpriseCorporateWrongdoing);

    public void saveOrUpd(EnterpriseCorporateWrongdoing enterpriseCorporateWrongdoing);

}
