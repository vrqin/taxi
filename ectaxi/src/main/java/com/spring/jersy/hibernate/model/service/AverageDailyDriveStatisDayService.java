package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.AverageDailyDriveStatisDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface AverageDailyDriveStatisDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public AverageDailyDriveStatisDay findByid(Integer id);

    public void delete(Integer id);

    public void save(AverageDailyDriveStatisDay averageDailyDriveStatisDay);

    public void saveOrUpd(AverageDailyDriveStatisDay averageDailyDriveStatisDay);

}
