package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.PassengerTopupStatisticsYear;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface PassengerTopupStatisticsYearService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public PassengerTopupStatisticsYear findByid(Integer id);

    public void delete(Integer id);

    public void save(PassengerTopupStatisticsYear passengerTopupStatisticsYear);

    public void saveOrUpd(PassengerTopupStatisticsYear passengerTopupStatisticsYear);

}
