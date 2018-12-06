package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.Freight;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface FreightService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public Freight findByid(Integer id);

    public void delete(Integer id);

    public void save(Freight freight);

    public void saveOrUpd(Freight freight);

}
