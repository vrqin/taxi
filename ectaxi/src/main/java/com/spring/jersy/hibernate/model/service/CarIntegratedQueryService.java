package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CarIntegratedQuery;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CarIntegratedQueryService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, Integer clientid) throws Exception;

    public CarIntegratedQuery findByid(Integer id);

    public void delete(Integer id);

    public void save(CarIntegratedQuery carIntegratedQuery);

    public void saveOrUpd(CarIntegratedQuery carIntegratedQuery);

}
