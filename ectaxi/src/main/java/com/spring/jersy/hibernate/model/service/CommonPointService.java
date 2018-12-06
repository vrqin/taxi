package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CommonPoint;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface CommonPointService {

    public List<CommonPoint> findList(String sort, String order, String position, String phone, Integer type, String geographical, Integer clientid) throws Exception;

    public CommonPoint findByid(Integer id);

    public CommonPoint findByGeographical(String phone, String geographical);

    public void delete(Integer id);

    public void save(CommonPoint commonPoint);

    public void saveOrUpd(CommonPoint commonPoint);

}
