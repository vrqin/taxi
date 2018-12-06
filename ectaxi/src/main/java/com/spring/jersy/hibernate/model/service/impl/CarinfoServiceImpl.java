package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CarinfoDao;
import com.spring.jersy.hibernate.model.entity.Carinfo;
import com.spring.jersy.hibernate.model.service.CarinfoService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CarinfoServiceImpl implements CarinfoService {

    @Autowired
    private CarinfoDao carinfoDao;

    public static StringBuffer CarinfoSqlList(String key, int clientid) {
        StringBuffer sqllsit = new StringBuffer();
        if (clientid > 0) {
            if (!S.isNull(key)) {
                sqllsit.append(" SELECT tc.id, tc.company, tc.installtime, tc.kabnum, tc.`schedule`, tc.simcard, tc.terminalid, tc.transportid, tc.transporttime, tc.unit, tc.carPic, tc.displacement, tc.mileage, tc.models, tc.type, tc.vehicleid, tc.yearcareful, tc.clientid, COUNT(driver3_.kabnumid) FROM tab_carinfo tc LEFT OUTER JOIN tab_carinfo_driver driverhash2_ ON tc.id = driverhash2_.id LEFT OUTER JOIN tab_driver driver3_ ON driverhash2_.driverid = driver3_.id WHERE (tc.company LIKE '%" + key + "%' OR tc.kabnum LIKE '%" + key + "%' OR tc.simcard LIKE '%" + key + "%') and tc.clientid=" + clientid + " GROUP BY tc.id ORDER BY tc.id DESC ");
            } else {
                sqllsit.append(" SELECT tc.id, tc.company, tc.installtime, tc.kabnum, tc.`schedule`, tc.simcard, tc.terminalid, tc.transportid, tc.transporttime, tc.unit, tc.carPic, tc.displacement, tc.mileage, tc.models, tc.type, tc.vehicleid, tc.yearcareful, tc.clientid, COUNT(driver3_.kabnumid) FROM tab_carinfo tc LEFT OUTER JOIN tab_carinfo_driver driverhash2_ ON tc.id = driverhash2_.id LEFT OUTER JOIN tab_driver driver3_ ON driverhash2_.driverid = driver3_.id WHERE tc.clientid=" + clientid + " GROUP BY tc.id ORDER BY tc.id DESC ");
            }

        } else {
            if (!S.isNull(key)) {
                sqllsit.append(" SELECT tc.id, tc.company, tc.installtime, tc.kabnum, tc.`schedule`, tc.simcard, tc.terminalid, tc.transportid, tc.transporttime, tc.unit, tc.carPic, tc.displacement, tc.mileage, tc.models, tc.type, tc.vehicleid, tc.yearcareful, tc.clientid, COUNT(driver3_.kabnumid) FROM tab_carinfo tc LEFT OUTER JOIN tab_carinfo_driver driverhash2_ ON tc.id = driverhash2_.id LEFT OUTER JOIN tab_driver driver3_ ON driverhash2_.driverid = driver3_.id WHERE (tc.company LIKE '%" + key + "%' OR tc.kabnum LIKE '%" + key + "%' OR tc.simcard LIKE '%" + key + "%')  GROUP BY tc.id ORDER BY tc.id DESC ");
            } else {
                sqllsit.append(" SELECT tc.id, tc.company, tc.installtime, tc.kabnum, tc.`schedule`, tc.simcard, tc.terminalid, tc.transportid, tc.transporttime, tc.unit, tc.carPic, tc.displacement, tc.mileage, tc.models, tc.type, tc.vehicleid, tc.yearcareful, tc.clientid, COUNT(driver3_.kabnumid) FROM tab_carinfo tc LEFT OUTER JOIN tab_carinfo_driver driverhash2_ ON tc.id = driverhash2_.id LEFT OUTER JOIN tab_driver driver3_ ON driverhash2_.driverid = driver3_.id   GROUP BY tc.id ORDER BY tc.id DESC ");
            }
        }


        return sqllsit;


    }

    public static StringBuffer CarinfoSimpleSqlList(String key, int clientid) {
        StringBuffer sqllsit = new StringBuffer();
        if (clientid > 0) {
            if (!S.isNull(key)) {
                sqllsit.append(" SELECT tc.kabnum, tc.clientid, tc.vehicleid, tc.mileage, tc.models,tc.displacement, tc.yearcareful FROM tab_carinfo tc LEFT OUTER JOIN tab_carinfo_driver driverhash2_ ON tc.id = driverhash2_.id LEFT OUTER JOIN tab_driver driver3_ ON driverhash2_.driverid = driver3_.id WHERE tc.clientid =" + clientid + " and tc.company LIKE '%" + key + "%' OR tc.kabnum LIKE '%" + key + "%' OR tc.simcard LIKE '%" + key + "%' GROUP BY tc.id ORDER BY tc.id DESC ");
                //sqllsit.append(" SELECT tc.kabnum, tc.clientid, tc.vehicleid, tc.mileage, tc.models,tc.displacement, tc.yearcareful FROM tab_carinfo tc LEFT OUTER JOIN tab_carinfo_driver driverhash2_ ON tc.id = driverhash2_.id LEFT OUTER JOIN tab_driver driver3_ ON driverhash2_.driverid = driver3_.id WHERE tc.clientid ="+clientid+" and tc.company LIKE '%"+key+"%' OR tc.kabnum LIKE '%"+key+"%' OR tc.simcard LIKE '%"+key+"%' GROUP BY tc.id ORDER BY tc.id DESC ");
            } else {
                sqllsit.append(" SELECT tc.kabnum, tc.clientid, tc.vehicleid, tc.mileage, tc.models,tc.displacement, tc.yearcareful FROM tab_carinfo tc LEFT OUTER JOIN tab_carinfo_driver driverhash2_ ON tc.id = driverhash2_.id LEFT OUTER JOIN tab_driver driver3_ ON driverhash2_.driverid = driver3_.id WHERE tc.clientid =" + clientid + "  GROUP BY tc.id ORDER BY tc.id DESC  ");
            }
        } else {
            if (!S.isNull(key)) {
                sqllsit.append(" SELECT tc.kabnum, tc.clientid, tc.vehicleid, tc.mileage, tc.models,tc.displacement, tc.yearcareful FROM tab_carinfo tc LEFT OUTER JOIN tab_carinfo_driver driverhash2_ ON tc.id = driverhash2_.id LEFT OUTER JOIN tab_driver driver3_ ON driverhash2_.driverid = driver3_.id WHERE tc.company LIKE '%" + key + "%' OR tc.kabnum LIKE '%" + key + "%' OR tc.simcard LIKE '%" + key + "%' GROUP BY tc.id ORDER BY tc.id DESC ");
            } else {
                sqllsit.append(" SELECT tc.kabnum, tc.clientid, tc.vehicleid, tc.mileage, tc.models,tc.displacement, tc.yearcareful FROM tab_carinfo tc LEFT OUTER JOIN tab_carinfo_driver driverhash2_ ON tc.id = driverhash2_.id LEFT OUTER JOIN tab_driver driver3_ ON driverhash2_.driverid = driver3_.id   GROUP BY tc.id ORDER BY tc.id DESC  ");
            }
        }


        return sqllsit;


    }

    public static StringBuffer CarinfoSqlTree(String company) {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT DISTINCT id,kabnum FROM `tab_carinfo` WHERE company ='" + company + "' ");
        return sqllsit;

    }

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Carinfo.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(kabnum like '%" + key + "%' or company like '%" + key + "%'or simcard like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("transporttime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("transporttime", end));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = carinfoDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public List<Carinfo> findSqlList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, int clientid) throws Exception {

        StringBuffer sqllsit = CarinfoSqlList(key, clientid);
        sqllsit.append(" LIMIT  " + (page - 1) * rows + "," + rows);
        List<Object[]> list = carinfoDao.findListSql(String.valueOf(sqllsit));
        List<Carinfo> callBusslist = new ArrayList<Carinfo>();
        Carinfo callBean;
        for (Object[] objects : list) {
            callBean = new Carinfo();
            callBean.setId(objects[0] == null ? 0 : Integer.parseInt(objects[0].toString()));
            callBean.setCompany(objects[1] == null ? "" : objects[1].toString());
            callBean.setInstalltime(objects[2] == null ? null : DateUtil.stringToDate(objects[2].toString(), "yyyy-MM-dd HH:mm:ss"));
            callBean.setKabnum(objects[3] == null ? "" : objects[3].toString());
            callBean.setSchedule(objects[4] == null ? 0 : Integer.parseInt(objects[4].toString()));
            callBean.setSimcard(objects[5] == null ? "" : objects[5].toString());
            callBean.setTerminalid(objects[6] == null ? "" : objects[6].toString());
            callBean.setTransportid(objects[7] == null ? "" : objects[7].toString());
            callBean.setTransporttime(objects[8] == null ? null : DateUtil.stringToDate(objects[8].toString(), "yyyy-MM-dd HH:mm:ss"));
            callBean.setUnit(objects[9] == null ? "" : objects[9].toString());
            callBean.setCarPic(objects[10] == null ? "" : objects[10].toString());
            callBean.setDisplacement(objects[11] == null ? 0 : Double.parseDouble(objects[11].toString()));
            callBean.setMileage(objects[12] == null ? 0 : Double.parseDouble(objects[12].toString()));
            callBean.setModels(objects[13] == null ? "" : objects[13].toString());
            callBean.setType(objects[14] == null ? "" : objects[14].toString());
            callBean.setVehicleid(objects[15] == null ? "" : objects[15].toString());
            callBean.setYearcareful(objects[16] == null ? null : DateUtil.stringToDate(objects[16].toString(), "yyyy-MM-dd HH:mm:ss"));
            callBean.setClientid(objects[17] == null ? 0 : Integer.parseInt(objects[17].toString()));
            callBean.setCarcount(objects[18] == null ? 0 : Integer.parseInt(objects[18].toString()));

            callBusslist.add(callBean);
        }
        return callBusslist;

    }

    @Override
    public PageList findSqlPageList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, int clientid) throws Exception {

        StringBuffer sqllsit = CarinfoSqlList(key, clientid);
        PageList pageList = new PageList(page, rows);
        pageList = carinfoDao.findPageList(pageList, String.valueOf(sqllsit), null);
        List<Object[]> list = pageList.getList();
        List<Carinfo> callBusslist = new ArrayList<Carinfo>();
        Carinfo callBean;
        for (Object[] objects : list) {
            callBean = new Carinfo();
            callBean.setId(objects[0] == null ? 0 : Integer.parseInt(objects[0].toString()));
            callBean.setCompany(objects[1] == null ? "" : objects[1].toString());
            callBean.setInstalltime(objects[2] == null ? null : DateUtil.stringToDate(objects[2].toString(), "yyyy-MM-dd HH:mm:ss"));
            callBean.setKabnum(objects[3] == null ? "" : objects[3].toString());
            callBean.setSchedule(objects[4] == null ? 0 : Integer.parseInt(objects[4].toString()));
            callBean.setSimcard(objects[5] == null ? "" : objects[5].toString());
            callBean.setTerminalid(objects[6] == null ? "" : objects[6].toString());
            callBean.setTransportid(objects[7] == null ? "" : objects[7].toString());
            callBean.setTransporttime(objects[8] == null ? null : DateUtil.stringToDate(objects[8].toString(), "yyyy-MM-dd HH:mm:ss"));
            callBean.setUnit(objects[9] == null ? "" : objects[9].toString());
            callBean.setCarPic(objects[10] == null ? "" : objects[10].toString());
            callBean.setDisplacement(objects[11] == null ? 0 : Double.parseDouble(objects[11].toString()));
            callBean.setMileage(objects[12] == null ? 0 : Double.parseDouble(objects[12].toString()));
            callBean.setModels(objects[13] == null ? "" : objects[13].toString());
            callBean.setType(objects[14] == null ? "" : objects[14].toString());
            callBean.setVehicleid(objects[15] == null ? "" : objects[15].toString());
            callBean.setYearcareful(objects[16] == null ? null : DateUtil.stringToDate(objects[16].toString(), "yyyy-MM-dd HH:mm:ss"));
            callBean.setClientid(objects[17] == null ? 0 : Integer.parseInt(objects[17].toString()));
            callBean.setCarcount(objects[18] == null ? 0 : Integer.parseInt(objects[18].toString()));

            callBusslist.add(callBean);
        }
        pageList.setList(callBusslist);
        return pageList;

    }

    @Override
    public List<Carinfo> findListbyKey(String key, int clientid) throws Exception {
        StringBuffer sqllsit = CarinfoSimpleSqlList(key, clientid);
        List<Object[]> list = carinfoDao.findListSql(String.valueOf(sqllsit));
        List<Carinfo> callBusslist = new ArrayList<Carinfo>();
        Carinfo callBean;
        for (Object[] objects : list) {
            callBean = new Carinfo();
            callBean.setKabnum(objects[0] == null ? "" : objects[0].toString());
            callBean.setClientid(objects[1] == null ? 0 : Integer.parseInt(objects[1].toString()));
            callBean.setVehicleid(objects[2] == null ? "" : objects[2].toString());
            callBean.setMileage(objects[3] == null ? 0 : Double.parseDouble(objects[3].toString()));
            callBean.setModels(objects[4] == null ? "" : objects[4].toString());
            callBean.setDisplacement(objects[5] == null ? 0 : Double.parseDouble(objects[5].toString()));
            callBean.setYearcareful(objects[6] == null ? null : DateUtil.stringToDate(objects[6].toString(), "yyyy-MM-dd HH:mm:ss"));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public Carinfo findByid(Integer id) {
        return carinfoDao.get(id);
    }

    @Override
    public Carinfo findByKabnum(String kabnum) {
        DetachedCriteria dc = DetachedCriteria.forClass(Carinfo.class);
        dc.add(Restrictions.eq("kabnum", kabnum));
        return carinfoDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public Carinfo findBycilentid(Integer clientid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Carinfo.class);
        dc.add(Restrictions.eq("clientid", clientid));
        return carinfoDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public Set<Carinfo> findBySetid(Integer id) {
        DetachedCriteria dc = DetachedCriteria.forClass(Carinfo.class);
        dc.add(Restrictions.eq("id", id));
        List<Carinfo> carinfos = carinfoDao.findByDetachedCriteria(dc);
        return new HashSet<Carinfo>(carinfos);
    }

    @Override
    public void delete(Integer id) {
        carinfoDao.delete(id);
    }

    @Override
    public void save(Carinfo carinfo) {
        carinfoDao.save(carinfo);
    }

    @Override
    public void saveOrUpd(Carinfo carinfo) {
        carinfoDao.saveOrUpdate(carinfo);
    }

    @Override
    public List<Carinfo> findListByPid(String company) {
        DetachedCriteria dc = DetachedCriteria.forClass(Carinfo.class);

        dc.add(Restrictions.eq("company", company));
        return carinfoDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<Carinfo> findListTreeByPid(String company) {
        StringBuffer sqllsit = CarinfoSqlTree(company);
        List<Object[]> list = carinfoDao.findListSql(String.valueOf(sqllsit));
        List<Carinfo> callBusslist = new ArrayList<Carinfo>();
        Carinfo callBean;
        for (Object[] objects : list) {
            callBean = new Carinfo();
            callBean.setId(objects[0] == null ? 0 : Integer.parseInt(objects[0].toString()));
            callBean.setKabnum(objects[1] == null ? "" : objects[1].toString());
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public boolean deleteCarinfToDriver(Integer carid, Integer driverid) {
        String sql = " DELETE FROM `tab_carinfo_driver` WHERE id = " + carid + " AND driverid = " + driverid;
        return carinfoDao.updateSql(sql);
    }

    public void deleteBatch(Integer[] ids) {
        carinfoDao.delBatch("tab_carinfo", ids);
    }

    @Override
    public int findCount() {
        return carinfoDao.findCount("select count(id) from tab_carinfo");
    }

    public List<Carinfo> findListByIDS(Integer[] ids) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Carinfo.class);
        criteria.add(Restrictions.in("id", ids));
        List<Carinfo> carinfos = carinfoDao.findByDetachedCriteria(criteria);
        return carinfos;
    }
}
