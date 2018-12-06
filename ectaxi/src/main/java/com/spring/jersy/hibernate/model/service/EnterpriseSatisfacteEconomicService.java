package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteEconomic;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseSatisfacteEconomicService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseSatisfacteEconomic findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseSatisfacteEconomic enterpriseSatisfacteEconomic);

    public void saveOrUpd(EnterpriseSatisfacteEconomic enterpriseSatisfacteEconomic);

}
