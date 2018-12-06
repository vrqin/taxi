package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.VersionManages;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface VersionManageService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public VersionManages findByid(Integer id);

    public void delete(Integer id);

    public void save(VersionManages versionManage);

    public void saveOrUpd(VersionManages versionManage);

}
