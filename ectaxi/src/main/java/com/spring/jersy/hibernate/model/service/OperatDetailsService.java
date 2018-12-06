package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.OperatDetails;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface OperatDetailsService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public OperatDetails findByid(Integer id);

    public void delete(Integer id);

    public void save(OperatDetails operatDetails);

    public void saveOrUpd(OperatDetails operatDetails);

}
