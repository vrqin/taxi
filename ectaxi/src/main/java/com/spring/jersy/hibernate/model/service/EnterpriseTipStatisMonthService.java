package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseTipStatisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseTipStatisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseTipStatisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseTipStatisMonth enterpriseTipStatisMonth);

    public void saveOrUpd(EnterpriseTipStatisMonth enterpriseTipStatisMonth);

}
