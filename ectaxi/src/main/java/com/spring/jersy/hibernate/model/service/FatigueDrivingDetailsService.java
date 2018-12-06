package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.FatigueDrivingDetails;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface FatigueDrivingDetailsService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public FatigueDrivingDetails findByid(Integer id);

    public void delete(Integer id);

    public void save(FatigueDrivingDetails fatigueDrivingDetails);

    public void saveOrUpd(FatigueDrivingDetails fatigueDrivingDetails);

}
