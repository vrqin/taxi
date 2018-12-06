package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteCartotal;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseSatisfacteCartotalService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseSatisfacteCartotal findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseSatisfacteCartotal enterpriseSatisfacteCartotal);

    public void saveOrUpd(EnterpriseSatisfacteCartotal enterpriseSatisfacteCartotal);

}
