package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DriverInformationAnalysisCreditrate;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface DriverInformationAnalysisCreditrateService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DriverInformationAnalysisCreditrate findByid(Integer id);

    public void delete(Integer id);

    public void save(DriverInformationAnalysisCreditrate driverInformationAnalysisCreditrate);

    public void saveOrUpd(DriverInformationAnalysisCreditrate driverInformationAnalysisCreditrate);

}
