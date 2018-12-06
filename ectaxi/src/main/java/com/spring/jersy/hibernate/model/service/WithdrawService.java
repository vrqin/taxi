package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.Withdraw;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

public interface WithdrawService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, int state) throws Exception;

    public Withdraw findByid(Integer id);

    public Withdraw findByOrderid(String orderid);

    public void delete(Integer id);

    public void save(Withdraw withdraw);

    public void saveOrUpd(Withdraw withdraw);

    public List<Withdraw> findListbyWithdrarwStatistics();
}
