package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CarInformationAnalysisValidittime;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CarInformationAnalysisValidittimeService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CarInformationAnalysisValidittime findByid(Integer id);

    public void delete(Integer id);

    public void save(CarInformationAnalysisValidittime carInformationAnalysisValidittime);

    public void saveOrUpd(CarInformationAnalysisValidittime carInformationAnalysisValidittime);

}
