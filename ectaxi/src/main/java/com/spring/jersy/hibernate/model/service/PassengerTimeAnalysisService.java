package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.PassengerTimeAnalysis;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface PassengerTimeAnalysisService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public PassengerTimeAnalysis findByid(Integer id);

    public void delete(Integer id);

    public void save(PassengerTimeAnalysis passengerTimeAnalysis);

    public void saveOrUpd(PassengerTimeAnalysis passengerTimeAnalysis);

}
