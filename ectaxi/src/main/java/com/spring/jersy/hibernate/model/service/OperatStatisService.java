package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.OperatStatis;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface OperatStatisService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, int clientid) throws Exception;

    public OperatStatis findByid(Integer id);

    public void delete(Integer id);

    public void save(OperatStatis operatStatis);

    public void saveOrUpd(OperatStatis operatStatis);

}
