package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.FatigueDrivingStatis;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface FatigueDrivingStatisService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public FatigueDrivingStatis findByid(Integer id);

    public void delete(Integer id);

    public void save(FatigueDrivingStatis fatigueDrivingStatis);

    public void saveOrUpd(FatigueDrivingStatis fatigueDrivingStatis);

}
