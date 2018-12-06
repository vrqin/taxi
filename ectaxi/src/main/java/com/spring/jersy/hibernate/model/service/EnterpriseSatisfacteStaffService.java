package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteStaff;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseSatisfacteStaffService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseSatisfacteStaff findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseSatisfacteStaff enterpriseSatisfacteStaff);

    public void saveOrUpd(EnterpriseSatisfacteStaff enterpriseSatisfacteStaff);

}
