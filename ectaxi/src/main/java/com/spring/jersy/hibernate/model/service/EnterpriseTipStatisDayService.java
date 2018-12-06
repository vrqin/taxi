package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseTipStatisDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseTipStatisDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseTipStatisDay findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseTipStatisDay enterpriseTipStatisDay);

    public void saveOrUpd(EnterpriseTipStatisDay enterpriseTipStatisDay);

}
