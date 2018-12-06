package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.Callstation;
import com.spring.jersy.hibernate.publics.util.PageList;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface CallstationService {

    public PageList findList(int page, int rows, String sort, String order, String position, String phone, int clientid) throws Exception;

    public Callstation findByid(Integer id);

    public void delete(Integer id);

    public void save(Callstation callstation);

    public void saveOrUpd(Callstation callstation);

}
