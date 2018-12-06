package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.UsagePlatform;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface UsagePlatformService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, int clientid) throws Exception;

    public UsagePlatform findByid(Integer id);

    public void delete(Integer id);

    public void save(UsagePlatform usagePlatform);

    public void saveOrUpd(UsagePlatform usagePlatform);

}
