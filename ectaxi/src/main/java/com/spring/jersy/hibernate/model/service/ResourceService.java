package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.Resource;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

public interface ResourceService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public PageList findListByorder(int page, int rows, String sort, String order) throws Exception;

    public Resource findByid(Integer id);

    public List<Resource> findListByPid(Integer pid, Integer ppid);


    public List<Resource> findListByid(Integer pid);

    public List<Resource> findListByPpid(Integer ppid);


    public void delete(Integer id);

    public void save(Resource resource);

    public void saveOrUpd(Resource resource);

}
