package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverEvaluationQuery;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverEvaluationQueryService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverEvaluationQuery findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverEvaluationQuery driverEvaluationQuery);

    public void saveOrUpd(DriverEvaluationQuery driverEvaluationQuery);

}
