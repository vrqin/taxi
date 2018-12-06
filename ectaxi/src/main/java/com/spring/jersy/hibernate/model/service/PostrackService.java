package com.spring.jersy.hibernate.model.service;


import com.spring.jersy.hibernate.model.entity.Postrack;
import com.spring.jersy.hibernate.publics.bean.PostrackBean;

import java.util.List;

/**
 * Created by Administrator on 2016/5/11.
 */
public interface PostrackService {

    public List<Postrack> findAllList(String orderid, int opertype) throws Exception;


    public List<Postrack> findListByKabnum(String startime, String endtime, String kabnum) throws Exception;


    public List<Postrack> findDriversByTime(String startime, String endtime) throws Exception;

    public List<PostrackBean> findDriverTrackByTime(String begintime, String endtime, String kabnum, String name, String phone, int clientid) throws Exception;

    public List<PostrackBean> findPosTrack(String begintime, String endtime, String kabnum, String name, String phone) throws Exception;
}
