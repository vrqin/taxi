package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.AverageDailyDriveStatisYear;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface AverageDailyDriveStatisYearService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public AverageDailyDriveStatisYear findByid(Integer id);

    public void delete(Integer id);

    public void save(AverageDailyDriveStatisYear averageDailyDriveStatisYear);

    public void saveOrUpd(AverageDailyDriveStatisYear averageDailyDriveStatisYear);

}
