package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.RegionalPoliceDetails;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface RegionalPoliceDetailsService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public RegionalPoliceDetails findByid(Integer id);

    public void delete(Integer id);

    public void save(RegionalPoliceDetails regionalPoliceDetails);

    public void saveOrUpd(RegionalPoliceDetails regionalPoliceDetails);

}
