package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.WithdrawStatisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface WithdrawStatisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public WithdrawStatisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(WithdrawStatisMonth withdrawStatisMonth);

    public void saveOrUpd(WithdrawStatisMonth withdrawStatisMonth);

}
