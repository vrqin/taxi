package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverIntegrity;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

/**
 * Created by Administrator on 2016/9/10.
 */
public interface DriverIntegrityService {
    public PageList findList(int page, int rows, String sort, String order, String phone, String name, String kabnum, String enterprise, Integer rating, Integer isblack, Integer clientid) throws Exception;

    List<DriverIntegrity> findPunishmentList(int page, int rows, String sort, String order, String key, String name, String kabnum, String enterprise, Integer rating, Integer isblack, Integer clientid) throws Exception;

    List<DriverIntegrity> findPunishmentList(String key, Integer clientid) throws Exception;

    public DriverIntegrity findDriverIntegrityByPhone(String phone);

    public void saveOrUpd(DriverIntegrity driverIntegrity);

}
