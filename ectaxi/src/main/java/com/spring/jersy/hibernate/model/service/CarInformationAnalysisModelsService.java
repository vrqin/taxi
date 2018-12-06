package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CarInformationAnalysisModels;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CarInformationAnalysisModelsService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CarInformationAnalysisModels findByid(Integer id);

    public void delete(Integer id);

    public void save(CarInformationAnalysisModels carInformationAnalysisModels);

    public void saveOrUpd(CarInformationAnalysisModels carInformationAnalysisModels);

}
