package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.Role;
import com.spring.jersy.hibernate.publics.bean.RoleidToResourseid;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

public interface RoleService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public Role findByid(Integer id);

    public void delete(Integer id);

    public void delRoleidReoursid(Integer id);

    public void save(Role role);

    public void saveOrUpd(Role role);

    public List<Role> findRoleList(String key, Integer clientid) throws Exception;

    public List<RoleidToResourseid> findRoleidToResourseidList(Integer key) throws Exception;

    public List<Role> findRoleListtree() throws Exception;

}
