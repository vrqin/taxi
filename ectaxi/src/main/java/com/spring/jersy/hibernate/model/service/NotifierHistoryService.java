package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.NotifierPlusHistory;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

public interface NotifierHistoryService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, Integer notifierid, Integer clientid) throws Exception;

    public NotifierPlusHistory findByid(Integer id);

    public List<NotifierPlusHistory> findBynodtfierid(Integer id);

    public void delete(Integer id);

    public void deletebynodtfierid(Integer id);

    public void save(NotifierPlusHistory notifierHistory);

    public void saveOrUpd(NotifierPlusHistory notifierHistory);

}
