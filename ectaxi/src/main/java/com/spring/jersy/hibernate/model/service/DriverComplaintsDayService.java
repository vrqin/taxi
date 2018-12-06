package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverComplaintsDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverComplaintsDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverComplaintsDay findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverComplaintsDay driverComplaintsDay);

    public void saveOrUpd(DriverComplaintsDay driverComplaintsDay);

}