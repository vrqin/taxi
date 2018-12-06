package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.ClientSetting;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

public interface ClientSettingService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public ClientSetting findByid(Integer id);

    public void delete(Integer id);

    public void save(ClientSetting clientSetting);

    public void saveOrUpd(ClientSetting clientSetting);


    public List<ClientSetting> findListByid(Integer id);
}
