package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.OperationsTimeHours;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface OperationsTimeHoursService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public OperationsTimeHours findByid(Integer id);

    public void delete(Integer id);

    public void save(OperationsTimeHours operationsTimeHours);

    public void saveOrUpd(OperationsTimeHours operationsTimeHours);

}
