package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverComplaintsMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverComplaintsMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverComplaintsMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverComplaintsMonth driverComplaintsMonth);

    public void saveOrUpd(DriverComplaintsMonth driverComplaintsMonth);

}
