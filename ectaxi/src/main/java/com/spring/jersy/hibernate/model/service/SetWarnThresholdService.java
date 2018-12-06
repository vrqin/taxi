package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.SetWarnThreshold;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface SetWarnThresholdService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public SetWarnThreshold findByid(Integer id);

    public void delete(Integer id);

    public void save(SetWarnThreshold setWarnThreshold);

    public void saveOrUpd(SetWarnThreshold setWarnThreshold);

}
