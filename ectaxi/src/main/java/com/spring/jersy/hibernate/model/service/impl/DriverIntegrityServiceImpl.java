package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverIntegrityDao;
import com.spring.jersy.hibernate.model.entity.DriverIntegrity;
import com.spring.jersy.hibernate.model.service.DriverIntegrityService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/10.
 */
@Service
public class DriverIntegrityServiceImpl implements DriverIntegrityService {

    @Autowired
    private DriverIntegrityDao driverIntegrityDao;

    public static StringBuffer PunishmentListSql(int clientid) {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT d.name,d.sex,d.kabnum,d.phone,d.clientid,IFNULL(driverorder.allorder,0) ,IFNULL(driverorder.cancelorder,0),d.isstop,publog.publognum FROM  ");
        sqllsit.append(" (SELECT  A.id,A.account,A.pwd,A.msid,A.kabnum,A.`name`,A.sex,A.phone,A.createtime,A.company,A.isstop,A.operationid,A.serialnum,A.clientid,A.terminalid   ");
        sqllsit.append(" FROM tab_driver A   ");
        sqllsit.append(" LEFT JOIN (SELECT tp.account, COUNT(tp.account) AS toaccount ,SUM(tp.mileage) AS tomileage,SUM(tp.money) AS tomoney,SUM(tp.vainmileage) AS tovainmileage FROM `tab_payrecords` tp GROUP BY account) B   ");
        sqllsit.append(" ON A.account = B.account   ");
        sqllsit.append(" ORDER BY A.account DESC) d   ");
        sqllsit.append(" LEFT JOIN   ");
        sqllsit.append(" ( SELECT o.msid AS drivername, COUNT(o.msid) AS allorder, SUM(`status` = 3) AS cancelorder FROM tab_phonecallbuss o WHERE o.calltime > date(NOW()) GROUP BY msid ORDER BY COUNT(msid) DESC ) driverorder   ");
        sqllsit.append(" ON d.msid = driverorder.drivername   ");

        sqllsit.append(" LEFT JOIN ( SELECT COUNT(msid) AS publognum, msid FROM `tab_punishment_log` publog GROUP BY msid ) publog ON d.msid = publog.msid  ");


        sqllsit.append(" WHERE  driverorder.cancelorder <>0 ");
        if (clientid > 0) {
            sqllsit.append(" and d.clientid = " + clientid);
        }
        return sqllsit;

    }

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String name, String kabnum, String enterprise, Integer rating, Integer isblack, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverIntegrity.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or phone like '%" + key + "%' or kabnum like '%" + key + "%'   or kabnum like '%" + key + "%')"));
        }

        if (!S.isNull(rating)) {
            dc.add(Restrictions.eq("rating", rating));
        }

        if (!S.isNull(isblack)) {
            dc.add(Restrictions.eq("isblacklist", isblack));
        }

        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverIntegrityDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public List<DriverIntegrity> findPunishmentList(int page, int rows, String sort, String order, String key, String name, String kabnum, String enterprise, Integer rating, Integer isblack, Integer clientid) throws Exception {
        return null;
    }

    @Override
    public List<DriverIntegrity> findPunishmentList(String key, Integer clientid) throws Exception {
        StringBuffer sqllsit = PunishmentListSql(clientid);
        List<Object[]> list = driverIntegrityDao.findListSql(String.valueOf(sqllsit));
        List<DriverIntegrity> callBusslist = new ArrayList<DriverIntegrity>();
        DriverIntegrity callBean;
        for (Object[] objects : list) {
            callBean = new DriverIntegrity();
            callBean.setName(objects[0] == null ? "" : objects[0].toString());
            callBean.setSex(objects[1] == "false" ? 1 : 0);
            callBean.setKabnum(objects[2] == null ? "" : objects[2].toString());
            callBean.setPhone(objects[3] == null ? "" : objects[3].toString());
            callBean.setClientid(objects[4] == null ? 0 : Integer.parseInt(objects[4].toString()));
            callBean.setCallnumber(objects[5] == null ? 0 : Integer.parseInt(objects[5].toString()));
            callBean.setCancelnumber(objects[6] == null ? 0 : Integer.parseInt(objects[6].toString()));
            callBean.setIsstop(objects[7] == null ? 0 : Integer.parseInt(objects[7].toString()));
            callBean.setPubishment(objects[8] == null ? 0 : Integer.parseInt(objects[8].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public DriverIntegrity findDriverIntegrityByPhone(String phone) {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverIntegrity.class);
        dc.add(Restrictions.eq("phone", phone));
        return driverIntegrityDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public void saveOrUpd(DriverIntegrity driverIntegrity) {
        driverIntegrityDao.saveOrUpdate(driverIntegrity);
    }
}
