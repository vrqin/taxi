package com.spring.jersy.hibernate.model.service;


import com.spring.jersy.hibernate.model.entity.Passenger;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

/**
 * Created by Administrator on 2016/3/17.
 */
public interface PassengerService {

    public Passenger findByid(String opruserid);

    public Passenger findByPass(String opruserid, String pws);

    public void delete(String opruserid);

    public void save(Passenger passenger);

    public void saveOrUpd(Passenger passenger);

    public PageList findPageList(int page, int rows, String sort, String order, String key, Integer type, String begintime, String endtime) throws Exception;

    public List<Passenger> findAllList(String begintime, String endtime) throws Exception;

}
