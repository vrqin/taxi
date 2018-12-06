package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseComplaintsMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseComplaintsMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseComplaintsMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseComplaintsMonth enterpriseComplaintsMonth);

    public void saveOrUpd(EnterpriseComplaintsMonth enterpriseComplaintsMonth);

}
