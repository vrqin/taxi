package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.RemindSet;
import com.spring.jersy.hibernate.publics.util.PageList;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface RemindSetService {

    public PageList findList(int page, int rows, String sort, String order, String key, Integer type, Integer extypes, Integer enable, Integer clientid) throws Exception;

    public RemindSet findByid(Integer id);

    public void delete(Integer id);

    public void save(RemindSet remindSet);

    public void saveOrUpd(RemindSet remindSet);


}
