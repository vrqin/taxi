package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.PassenIntegrity;
import com.spring.jersy.hibernate.publics.util.PageList;

/**
 * Created by Administrator on 2016/9/10.
 */
public interface PassenIntegrityService {
    public PageList findList(int page, int rows, String sort, String order, String key, Integer isblacklist, String begintime, String endtime, Integer clientid) throws Exception;

    public PassenIntegrity findPassenIntegrityByPhone(String phone);

    public void saveOrUpd(PassenIntegrity passenIntegrity);

}
