package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.WithdrawStatisList;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface WithdrawStatisListService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public WithdrawStatisList findByid(Integer id);

    public void delete(Integer id);

    public void save(WithdrawStatisList withdrawStatisList);

    public void saveOrUpd(WithdrawStatisList withdrawStatisList);

}
