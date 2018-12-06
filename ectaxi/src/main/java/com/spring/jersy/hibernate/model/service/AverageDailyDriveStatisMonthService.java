package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.AverageDailyDriveStatisMonth;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface AverageDailyDriveStatisMonthService {

    public PageList findList(int page, int rows, String sort, String order, String key, String annual, int cycle, int type) throws Exception;

    public AverageDailyDriveStatisMonth findByid(Integer id);

    public void delete(Integer id);

    public void save(AverageDailyDriveStatisMonth averageDailyDriveStatisMonth);

    public void saveOrUpd(AverageDailyDriveStatisMonth averageDailyDriveStatisMonth);

}
