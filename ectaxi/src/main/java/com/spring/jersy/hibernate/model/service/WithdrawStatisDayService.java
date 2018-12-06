package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.WithdrawStatisDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface WithdrawStatisDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public WithdrawStatisDay findByid(Integer id);

    public void delete(Integer id);

    public void save(WithdrawStatisDay withdrawStatisDay);

    public void saveOrUpd(WithdrawStatisDay withdrawStatisDay);

}
