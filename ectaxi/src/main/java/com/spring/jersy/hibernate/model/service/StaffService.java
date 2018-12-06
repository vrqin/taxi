package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.Staff;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface StaffService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public Staff findByid(Integer id);

    public void delete(Integer id);

    public void save(Staff staff);

    public void saveOrUpd(Staff staff);

}
