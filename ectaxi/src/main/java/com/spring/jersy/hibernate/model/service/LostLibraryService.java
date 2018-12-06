package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.LostLibrary;
import com.spring.jersy.hibernate.publics.util.PageList;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface LostLibraryService {
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, String getonstartime, String getonendtime, Byte classify, Byte state, Integer clientid) throws Exception;

    public LostLibrary findByid(Integer id);

    public void delete(Integer id);

    public void save(LostLibrary lostLibrary);

    public void saveOrUpd(LostLibrary lostLibrary);

}
