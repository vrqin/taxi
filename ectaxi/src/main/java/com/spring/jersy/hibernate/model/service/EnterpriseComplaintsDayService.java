package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseComplaintsDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseComplaintsDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseComplaintsDay findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseComplaintsDay enterpriseComplaintsDay);

    public void saveOrUpd(EnterpriseComplaintsDay enterpriseComplaintsDay);

}
