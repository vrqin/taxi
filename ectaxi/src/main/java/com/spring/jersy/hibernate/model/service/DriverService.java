package com.spring.jersy.hibernate.model.service;


import com.spring.jersy.hibernate.model.entity.Driver;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/3/17.
 */
public interface DriverService {

    public Driver findByid(Integer id);

    public Set<Driver> findBySetid(Integer id);

    public Driver findByName(String name);

    public Driver findByPhone(String phone);

    public Driver findByMsid(String msid);

    public void delete(Integer id);

    public void save(Driver driver);

    public void saveOrUpd(Driver driver);

    public PageList findPageList(int page, int rows, String sort, String order, String key, Integer isstop, Integer isonline, String begintime, String endtime, Integer kabnumid, Integer clientid)
            throws Exception;

    public List<Driver> findAllList();

    public List<Driver> findAllList(String key, Integer isstop, Integer isonline, String begintime, String endtime, int clientid)
            throws Exception;

    public List<Driver> findAllListByCarName(String key);

    public Driver findDriverByCarName(String kabnum);

    public List<Driver> findListByStatus(Integer status, Integer clientid);

    public List<Driver> findListByOnOffline(String kabnum, Integer status, Integer clientid);

    public PageList findListByOnOfflinepage(int page, int rows, String kabnum, Integer status, Integer clientid);

    public List<Driver> findListByOnOfflineMsid(String msid, Integer status, Integer clientid);

    public PageList findListByOnOfflineMsidpage(int page, int rows, String msid, Integer status, Integer clientid);

    public List<Driver> findDriverPosition();

    public List<Driver> findDriverPositionByTime(String lasttime) throws Exception;

    public List<Driver> findDriverByClientId(Integer clientid);

    public List<Driver> findListByIDS(Integer[] ids);

    public List<Driver> findDriverremainByClientId(Integer clientid);

    public Number findCount(Integer clientid);

    public Number findCount();

}
