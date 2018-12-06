package com.spring.jersy.hibernate.model.service;


import com.spring.jersy.hibernate.model.entity.User;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

/**
 * Created by Administrator on 2016/3/17.
 */
public interface UserService {
    public User login(String username, String passwd);

    public List<User> findList(String sort, String order, String key, Integer type) throws Exception;

    public User findByid(Integer userid);

    public void delete(Integer userid);

    public void save(User user);

    public void saveOrUpd(User user);

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;


    public List<User> findSqlList(String sort, String order, String key, Integer type, int clientid) throws Exception;


    public User findUserByaccount(String account);

    public void deleteUserToPri(Integer id);

}
