package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.Client;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

public interface ClientService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public List<Client> findList();

    public Client findByid(Integer id);

    public void delete(Integer id);

    public void deleteCarinfToDriver(Integer carid, Integer driverid);

    public void save(Client client);

    public void saveOrUpd(Client client);

    public Client findListByCityflagId(Integer cityflag);


    public Client findbyCompany(String company);

    public List<Client> findListById(Integer cityflag);

    public List<Client> findListByPid(Integer Pid);


}
