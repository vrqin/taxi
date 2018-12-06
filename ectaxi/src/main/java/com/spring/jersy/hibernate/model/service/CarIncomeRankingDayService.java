package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.CarIncomeRankingDay;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface CarIncomeRankingDayService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public CarIncomeRankingDay findByid(Integer id);

    public void delete(Integer id);

    public void save(CarIncomeRankingDay carIncomeRankingDay);

    public void saveOrUpd(CarIncomeRankingDay carIncomeRankingDay);

}
