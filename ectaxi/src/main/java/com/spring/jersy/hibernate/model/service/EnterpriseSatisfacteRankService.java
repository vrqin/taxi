package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteRank;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface EnterpriseSatisfacteRankService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public EnterpriseSatisfacteRank findByid(Integer id);

    public void delete(Integer id);

    public void save(EnterpriseSatisfacteRank enterpriseSatisfacteRank);

    public void saveOrUpd(EnterpriseSatisfacteRank enterpriseSatisfacteRank);

}
