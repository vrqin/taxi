package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.TypeValue;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

public interface TypevalueService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public TypeValue findByid(Integer id);

    public void delete(Integer id);

    public void save(TypeValue typevalue);

    public void saveOrUpd(TypeValue typevalue);

    public List<TypeValue> findListByKey(String code);

}
