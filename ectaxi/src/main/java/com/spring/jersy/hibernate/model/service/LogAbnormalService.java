package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.LogAbnormal;
import com.spring.jersy.hibernate.publics.util.PageList;

/**
 * Created by Administrator on 2016/9/12.
 */
public interface LogAbnormalService {
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer clientid) throws Exception;

    public LogAbnormal findByid(Integer id);

    public void save(LogAbnormal logAbnormal);

    public void saveOrUpd(LogAbnormal logAbnormal);

    public void savelogAbnormal(String token, String content, Integer clientid);

}
