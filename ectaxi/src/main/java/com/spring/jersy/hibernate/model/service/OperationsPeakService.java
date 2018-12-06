package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.OperationsPeak;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface OperationsPeakService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public OperationsPeak findByid(Integer id);

    public void delete(Integer id);

    public void save(OperationsPeak operationsPeak);

    public void saveOrUpd(OperationsPeak operationsPeak);

}
