package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.PassengerTopupStatisticsDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface PassengerTopupStatisticsDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public PassengerTopupStatisticsDay findByid(Integer id);

    public void delete(Integer id);

    public void save(PassengerTopupStatisticsDay passengerTopupStatisticsDay);

    public void saveOrUpd(PassengerTopupStatisticsDay passengerTopupStatisticsDay);

}
