package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.ClientDao;
import com.spring.jersy.hibernate.model.entity.Client;
import com.spring.jersy.hibernate.model.service.ClientService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Client.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(clientName like '%" + key + "%' or contactperson like '%" + key + "%'or phone like '%" + key + "%')"));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("cityFlag", type));
        }

        if ("asc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = clientDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public List<Client> findList() {
        return clientDao.listAll();
    }

    @Override
    public Client findByid(Integer id) {
        return clientDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        clientDao.delete(id);
    }

    @Override
    public void deleteCarinfToDriver(Integer carid, Integer driverid) {
        String sql = "SELECT * FROM `tab_carinfo_driver` WHERE id = " + carid + " AND driverid = " + driverid;
        clientDao.updateSql(sql);
    }

    @Override
    public void save(Client client) {
        clientDao.save(client);
    }

    @Override
    public void saveOrUpd(Client client) {
        clientDao.saveOrUpdate(client);
    }

    @Override
    public List<Client> findListById(Integer cityflag) {
        DetachedCriteria dc = DetachedCriteria.forClass(Client.class);
        dc.add(Restrictions.eq("cityFlag", cityflag));
        return clientDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<Client> findListByPid(Integer Pid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Client.class);
        dc.add(Restrictions.eq("pid", Pid));
        return clientDao.findByDetachedCriteria(dc);
    }

    @Override
    public Client findListByCityflagId(Integer cityflag) {
        DetachedCriteria dc = DetachedCriteria.forClass(Client.class);
        dc.add(Restrictions.eq("cityFlag", cityflag));
        return clientDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public Client findbyCompany(String company) {
        DetachedCriteria dc = DetachedCriteria.forClass(Client.class);
        dc.add(Restrictions.eq("company", company));
        return clientDao.findByDetachedCriteriaObj(dc);
    }


}
