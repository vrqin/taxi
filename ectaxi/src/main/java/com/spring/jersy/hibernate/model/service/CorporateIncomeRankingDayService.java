package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CorporateIncomeRankingDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CorporateIncomeRankingDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CorporateIncomeRankingDay findByid(Integer id);

    public void delete(Integer id);

    public void save(CorporateIncomeRankingDay corporateIncomeRankingDay);

    public void saveOrUpd(CorporateIncomeRankingDay corporateIncomeRankingDay);

}
