package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteFunds;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseSatisfacteFundsService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseSatisfacteFunds findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseSatisfacteFunds enterpriseSatisfacteFunds);

    public void saveOrUpd(EnterpriseSatisfacteFunds enterpriseSatisfacteFunds);

}
