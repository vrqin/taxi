package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.Privilege;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

public interface PrivilegeService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public Privilege findByid(Integer id);

    public void delete(Integer id);

    public void save(Privilege privilege);

    public void saveOrUpd(Privilege privilege);

    public List<Privilege> findList();

}
