package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseTipDetails;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseTipDetailsService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseTipDetails findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseTipDetails enterpriseTipDetails);

    public void saveOrUpd(EnterpriseTipDetails enterpriseTipDetails);

}
