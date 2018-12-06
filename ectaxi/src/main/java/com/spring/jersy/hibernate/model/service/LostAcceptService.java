package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.LostAccept;
import com.spring.jersy.hibernate.publics.util.PageList;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface LostAcceptService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, String getonstartime, String getonendtime, Byte classify, Integer clientid) throws Exception;

    public LostAccept findByid(Integer id);

    public void delete(Integer id);

    public void save(LostAccept lostAccept);

    public void saveOrUpd(LostAccept lostAccept);

}
