package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.NotifierPlus;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface NotifierPlusService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, Integer clientid) throws Exception;

    public NotifierPlus findByid(Integer id);

    public void delete(Integer id);

    public void save(NotifierPlus notifierPlus);

    public void saveOrUpd(NotifierPlus notifierPlus);

}
