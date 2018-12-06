package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.PassengerTopupDetail;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface PassengerTopupDetailService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public PassengerTopupDetail findByid(Integer id);

    public void delete(Integer id);

    public void save(PassengerTopupDetail passengerTopupDetail);

    public void saveOrUpd(PassengerTopupDetail passengerTopupDetail);

}
