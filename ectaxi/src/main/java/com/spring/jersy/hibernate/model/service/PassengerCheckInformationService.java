package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.PassengerCheckInformation;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface PassengerCheckInformationService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public PassengerCheckInformation findByid(Integer id);

    public void delete(Integer id);

    public void save(PassengerCheckInformation passengerCheckInformation);

    public void saveOrUpd(PassengerCheckInformation passengerCheckInformation);

}
