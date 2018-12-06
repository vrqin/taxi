package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EmergencyAlarmStatis;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EmergencyAlarmStatisService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EmergencyAlarmStatis findByid(Integer id);

    public void delete(Integer id);

    public void save(EmergencyAlarmStatis emergencyAlarmStatis);

    public void saveOrUpd(EmergencyAlarmStatis emergencyAlarmStatis);

}
