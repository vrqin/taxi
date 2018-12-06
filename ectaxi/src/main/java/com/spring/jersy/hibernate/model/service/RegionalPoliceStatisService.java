package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.RegionalPoliceStatis;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface RegionalPoliceStatisService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public RegionalPoliceStatis findByid(Integer id);

    public void delete(Integer id);

    public void save(RegionalPoliceStatis regionalPoliceStatis);

    public void saveOrUpd(RegionalPoliceStatis regionalPoliceStatis);

}
