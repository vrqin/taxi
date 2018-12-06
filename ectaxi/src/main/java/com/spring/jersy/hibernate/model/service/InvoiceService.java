package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.Invoice;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface InvoiceService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public Invoice findByid(Integer id);

    public void delete(Integer id);

    public void save(Invoice invoice);

    public void saveOrUpd(Invoice invoice);

}
