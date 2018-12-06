package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverInformationAnalysisRegion;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverInformationAnalysisRegionService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverInformationAnalysisRegion findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverInformationAnalysisRegion driverInformationAnalysisRegion);

    public void saveOrUpd(DriverInformationAnalysisRegion driverInformationAnalysisRegion);

}
