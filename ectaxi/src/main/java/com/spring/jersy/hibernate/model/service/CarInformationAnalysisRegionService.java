package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CarInformationAnalysisRegion;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CarInformationAnalysisRegionService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CarInformationAnalysisRegion findByid(Integer id);

    public void delete(Integer id);

    public void save(CarInformationAnalysisRegion carInformationAnalysisRegion);

    public void saveOrUpd(CarInformationAnalysisRegion carInformationAnalysisRegion);

}
