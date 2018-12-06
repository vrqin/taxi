package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.OperatingSituation;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface OperatingSituationService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, int clientid) throws Exception;

    public OperatingSituation findByid(Integer id);

    public void delete(Integer id);

    public void save(OperatingSituation operatingSituation);

    public void saveOrUpd(OperatingSituation operatingSituation);

}
