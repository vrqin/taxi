package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseAnnualRating;

import java.util.List;

public interface EnterpriseAnnualRatingService {

    public List<EnterpriseAnnualRating> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

    public EnterpriseAnnualRating findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseAnnualRating enterpriseAnnualRating);

    public void saveOrUpd(EnterpriseAnnualRating enterpriseAnnualRating);

}
