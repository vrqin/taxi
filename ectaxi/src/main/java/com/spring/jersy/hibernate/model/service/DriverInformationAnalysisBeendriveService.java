package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverInformationAnalysisBeendrive;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverInformationAnalysisBeendriveService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverInformationAnalysisBeendrive findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverInformationAnalysisBeendrive driverInformationAnalysisBeendrive);

    public void saveOrUpd(DriverInformationAnalysisBeendrive driverInformationAnalysisBeendrive);

}
