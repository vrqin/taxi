package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.Complaint;
import com.spring.jersy.hibernate.publics.util.PageList;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface ComplaintService {
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, Byte source, Byte results, Byte state, Integer clientid) throws Exception;

    public Complaint findByid(Integer id);

    public void delete(Integer id);

    public void save(Complaint complaint);

    public void saveOrUpd(Complaint complaint);

}
