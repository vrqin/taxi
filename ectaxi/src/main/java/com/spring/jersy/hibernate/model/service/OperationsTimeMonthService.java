package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.OperationsTimeMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface OperationsTimeMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public OperationsTimeMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(OperationsTimeMonth operationsTimeMonth);

    public void saveOrUpd(OperationsTimeMonth operationsTimeMonth);

}
