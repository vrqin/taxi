package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.AssessManage;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface AssessManageService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public AssessManage findByid(Integer id);

    public void delete(Integer id);

    public void save(AssessManage assessManage);

    public void saveOrUpd(AssessManage assessManage);

}
