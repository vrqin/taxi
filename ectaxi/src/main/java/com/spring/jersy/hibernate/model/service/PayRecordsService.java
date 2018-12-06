package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.PayRecords;
import com.spring.jersy.hibernate.publics.bean.WalletBean;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public interface PayRecordsService {
    public PageList findPageList(int page, int rows, String sort, String order, String key, String begintime, String endtime) throws Exception;

    public List<PayRecords> findList(String key) throws Exception;

    public List<PayRecords> findListbyPayRecords(String account, Integer status);

    public List<WalletBean> findListbyPayRecordsWallet();

    public PayRecords findByid(Integer id);

    public PayRecords findByorderid(String orderid);

    public void delete(Integer id);

    public void save(PayRecords passPayDetails);

    public void saveOrUpd(PayRecords passPayDetails);
}
