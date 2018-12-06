package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.OverspeedAlarmStatis;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface OverspeedAlarmStatisService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public OverspeedAlarmStatis findByid(Integer id);

    public void delete(Integer id);

    public void save(OverspeedAlarmStatis overspeedAlarmStatis);

    public void saveOrUpd(OverspeedAlarmStatis overspeedAlarmStatis);

}
