package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CarInformationAnalysisFueltype;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CarInformationAnalysisFueltypeService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CarInformationAnalysisFueltype findByid(Integer id);

    public void delete(Integer id);

    public void save(CarInformationAnalysisFueltype carInformationAnalysisFueltype);

    public void saveOrUpd(CarInformationAnalysisFueltype carInformationAnalysisFueltype);

}
