package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CarIncomeRanking;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CarIncomeRankingService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, Integer clientid) throws Exception;

    public CarIncomeRanking findByid(Integer id);

    public void delete(Integer id);

    public void save(CarIncomeRanking carIncomeRanking);

    public void saveOrUpd(CarIncomeRanking carIncomeRanking);

}
