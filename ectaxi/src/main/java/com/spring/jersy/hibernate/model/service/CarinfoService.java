package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.Carinfo;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;
import java.util.Set;

public interface CarinfoService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public List<Carinfo> findSqlList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, int clientid) throws Exception;

    public PageList findSqlPageList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, int clientid) throws Exception;

    public List<Carinfo> findListbyKey(String key, int clientid) throws Exception;

    public Carinfo findByid(Integer id);

    public Carinfo findByKabnum(String kabnum);

    public Carinfo findBycilentid(Integer clientid);

    public Set<Carinfo> findBySetid(Integer id);

    public void delete(Integer id);

    public void save(Carinfo carinfo);

    public void saveOrUpd(Carinfo carinfo);

    public List<Carinfo> findListByPid(String company);

    public List<Carinfo> findListTreeByPid(String company);

    public boolean deleteCarinfToDriver(Integer carid, Integer driverid);

    public List<Carinfo> findListByIDS(Integer[] ids);

    public void deleteBatch(Integer[] ids);

    public int findCount();
}
