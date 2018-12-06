package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.Seats;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface SeatsService {
    public PageList findPageList(int page, int rows, String sort, String order, String key, Integer type, String begintime, String endtime, int clientid) throws Exception;

    public List<Seats> findList(String sort, String order, String key) throws Exception;

    public Seats findByid(Integer id);

    public Seats findByName(String name);

    public Seats findByAccount(String account);

    public Seats findByOpruser(String account);

    public Seats findBySeatlogin(String account, String pwd);

    public Seats findByPhone(String phone);

    public void delete(String opruserid);

    public void save(Seats seats);

    public void saveOrUpd(Seats seats);
}
