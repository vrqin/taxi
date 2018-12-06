package com.spring.jersy.hibernate.model.service.impl;


import com.spring.jersy.hibernate.model.dao.DefaultPositionDao;
import com.spring.jersy.hibernate.model.dao.DriverDao;
import com.spring.jersy.hibernate.model.entity.DefaultPosition;
import com.spring.jersy.hibernate.model.entity.Driver;
import com.spring.jersy.hibernate.model.service.DriverService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2016/5/4.
 */
@Service
public class DriverServiceimpl implements DriverService {

    private Double lt = 0.0;
    private Double lg = 0.0;
    private Date gpstime;

    @Autowired
    private DriverDao driverDao;

    @Autowired
    private DefaultPositionDao defaultPositionDao;

    @Override
    public Driver findByid(Integer id) {
        return driverDao.get(id);
    }

    @Override
    public Set<Driver> findBySetid(Integer id) {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        dc.add(Restrictions.eq("kabnumid", id));
        List<Driver> carinfos = driverDao.findByDetachedCriteria(dc);
        return new HashSet<Driver>(carinfos);
    }

    @Override
    public Driver findByName(String name) {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        dc.add(Restrictions.eq("account", name));
        return driverDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public Driver findByPhone(String phone) {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        dc.add(Restrictions.eq("phone", phone));
        return driverDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public Driver findByMsid(String msid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        dc.add(Restrictions.eq("msid", msid));
        return driverDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public void delete(Integer id) {
        driverDao.delete(id);
    }

    @Override
    public void save(Driver driver) {
        driverDao.save(driver);
    }

    @Override
    public void saveOrUpd(Driver driver) {
        driverDao.saveOrUpdate(driver);
    }

    @Override
    public PageList findPageList(int page, int rows, String sort, String order, String key, Integer isstop, Integer isonline, String begintime, String endtime, Integer kabnumid, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("( this_.kabnum like '%" + key + "%' or account like '%" + key + "%' or msid like '%" + key + "%' or phone like '%" + key + "%' or name like '%" + key + "%' or this_.company like '%" + key + "%')"));
        }


        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("createtime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("createtime", end));
        }

        if (isonline > (-1)) {
            dc.add(Restrictions.eq("isonline", isonline));
        }

        if (isstop > (-1)) {
            dc.add(Restrictions.eq("isstop", isstop));
        }

        if (!S.isNull(kabnumid)) {
            dc.add(Restrictions.eq("kabnumid", kabnumid));
        }
        if (!S.isNull(clientid)) {
            if (clientid > (0)) {
                dc.add(Restrictions.eq("clientid", clientid));
            }
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc("isonline"));
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.desc("isonline"));
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public List<Driver> findAllList() {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        dc.addOrder(Order.desc("createtime"));
        return driverDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<Driver> findAllList(String key, Integer isstop, Integer isonline, String begintime, String endtime, int clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(account like '%" + key + "%' or msid like '%" + key + "%' or phone like '%" + key + "%' or kabnum like '%" + key + "%' or company like '%" + key + "%')"));
        }
        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }

        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("createtime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("createtime", end));
        }

        if (isonline > (-1)) {
            dc.add(Restrictions.eq("isonline", isonline));
        }

        if (isstop > (-1)) {
            dc.add(Restrictions.eq("isstop", isstop));
        }
        dc.addOrder(Order.desc("createtime"));
        return driverDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<Driver> findAllListByCarName(String key) {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        //        dc.add(Restrictions.like("kabnum","%"+key+"%"));
        dc.add(Restrictions.sqlRestriction("kabnum like '%" + key + "%' GROUP BY kabnum order by isonline desc"));

        return driverDao.findByDetachedCriteria(dc);
    }

    @Override
    public Driver findDriverByCarName(String kabnum) {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        dc.add(Restrictions.like("kabnum", "%" + kabnum + "%"));
        dc.addOrder(Order.desc("gpstime"));
        //        dc.add(Restrictions.sqlRestriction("kabnum like '%"+kabnum+"%' GROUP BY kabnum order by isonline desc"));

        List<Driver> driverListTemp = driverDao.findByDetachedCriteria(dc);
        Driver driver = driverListTemp.get(0);
        return driver;
    }

    @Override
    public List<Driver> findListByStatus(Integer status, Integer clientid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        if (clientid != 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }
        if (status != S.DRIVER_ALL) {
            if (status == S.DRIVER_ONLINE) {
                dc.add(Restrictions.eq("isonline", 1));
            } else {
                dc.add(Restrictions.eq("isonline", 0));
            }
        }

        return driverDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<Driver> findListByOnOffline(String kabnum, Integer status, Integer clientid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        if (!S.isNull(kabnum)) {
            dc.add(Restrictions.sqlRestriction("(this_.kabnum like '%" + kabnum + "%')"));
        }

        if (!S.isNull(status)) {
            dc.add(Restrictions.eq("isonline", status));
        }

        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }

        return driverDao.findByDetachedCriteria(dc);
    }

    @Override
    public PageList findListByOnOfflinepage(int page, int rows, String kabnum, Integer status, Integer clientid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        if (!S.isNull(kabnum)) {
            dc.add(Restrictions.sqlRestriction("(this_.kabnum like '%" + kabnum + "%')"));
        }

        if (!S.isNull(status)) {
            dc.add(Restrictions.eq("isonline", status));
        }

        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public List<Driver> findListByOnOfflineMsid(String msid, Integer status, Integer clientid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        if (!S.isNull(msid)) {
            dc.add(Restrictions.sqlRestriction("(msid like '%" + msid + "%')"));
        }

        if (!S.isNull(status)) {
            dc.add(Restrictions.eq("isonline", status));
        }
        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }

        return driverDao.findByDetachedCriteria(dc);
    }

    @Override
    public PageList findListByOnOfflineMsidpage(int page, int rows, String msid, Integer status, Integer clientid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        if (!S.isNull(msid)) {
            dc.add(Restrictions.sqlRestriction("(msid like '%" + msid + "%')"));
        }

        if (!S.isNull(status)) {
            dc.add(Restrictions.eq("isonline", status));
        }
        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public List<Driver> findDriverPosition() {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        dc.addOrder(Order.desc("gpstime"));
        List<Driver> driverListTemp = driverDao.findByDetachedCriteria(dc);

        Map<String, Driver> map = new HashMap<String, Driver>();
        for (int i = 0; i < driverListTemp.size(); i++) {
            //使用map集合过滤重复车辆，一台出租车，有多个司机情况
            if (map.get(driverListTemp.get(i).getKabnum()) == null) {
                map.put(driverListTemp.get(i).getKabnum(), driverListTemp.get(i));
            } else {
                //如果在已用是集合中存在司机，如果gps为空替换不为空的
                if (map.get(driverListTemp.get(i).getKabnum()).getGpstime() == null) {
                    map.put(driverListTemp.get(i).getKabnum(), driverListTemp.get(i));
                } else {
                    //如果集合里的gps时间小于新的同一台车的其他时间gps时间进行替换
                    if (driverListTemp.get(i).getGpstime() != null) {
                        if (map.get(driverListTemp.get(i).getKabnum()).getGpstime().getTime() < driverListTemp.get(i)
                                .getGpstime()
                                .getTime()) {
                            map.put(driverListTemp.get(i).getKabnum(), driverListTemp.get(i));
                        }
                    }
                }
            }

        }
        //把map 转换成list
        List<Driver> driverList = new ArrayList<Driver>();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            driverList.add(map.get(key));
        }

        DefaultPosition dp = findDefaultPosition();
        if (!S.isNull(dp)) {
            lg = dp.getDeflg();
            lt = dp.getDeflt();
            gpstime = dp.getGpstime();
        }
        //把没有经纬度的车辆加经纬度，有经纬度转百度坐标
        if (!S.isNull(driverList) && driverList.size() > 0) {
            for (Driver d : driverList) {
                if (d.getLastlt() == null && d.getLastlg() == null) {
                    //设置默认经纬度
                    d.setLastlt(lt);
                    d.setLastlg(lg);
                    d.setGpstime(gpstime);

                }
                //                else{
                //                    GpsEntity gpsEntity = ChangeGps.wgs84Tobd09(d.getLastlt(),d.getLastlg());
                //                    if (!S.isNull(gpsEntity)){
                //                        d.setLastlg(gpsEntity.getLongitude());
                //                        d.setLastlt(gpsEntity.getLatitude());
                //                    }else{
                //                        //System.out.println(d.getName()+"转换失败！");
                //                    }
                //                }
            }
        }

        Collections.sort(driverList);
        return driverList;
    }

    @Override
    public List<Driver> findDriverPositionByTime(String lasttime) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);

        if (!S.isNull(lasttime)) {
            Date start = DateUtil.stringToDate(lasttime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("gpstime", start));
        }

        List<Driver> driverList = driverDao.findByDetachedCriteria(dc);
        //        if (!S.isNull(driverList)&& driverList.size()>0){
        //            for(Driver d:driverList){
        //                if (d.getLastlt()!=null&&d.getLastlg()!=null){
        //                    GpsEntity gpsEntity = ChangeGps.wgs84Tobd09(d.getLastlt(),d.getLastlg());
        //                    if (!S.isNull(gpsEntity)){
        //                        d.setLastlg(gpsEntity.getLongitude());
        //                        d.setLastlt(gpsEntity.getLatitude());
        //                    }else{
        //                        //System.out.println(d.getName()+"转换失败！");
        //                    }
        //
        //                }
        //            }
        //        }
        Collections.sort(driverList);
        return driverList;
    }

    @Override
    public List<Driver> findDriverByClientId(Integer clientid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        dc.add(Restrictions.eq("clientid", clientid));
        dc.addOrder(Order.desc("kabnum"));
        List<Driver> driverListTemp = driverDao.findByDetachedCriteria(dc);


        Map<String, Driver> map = new HashMap<String, Driver>();
        for (int i = 0; i < driverListTemp.size(); i++) {
            //使用map集合过滤重复车辆，一台出租车，有多个司机情况
            if (map.get(driverListTemp.get(i).getKabnum()) == null) {
                map.put(driverListTemp.get(i).getKabnum(), driverListTemp.get(i));
            } else {
                //如果在已用是集合中存在司机，如果gps为空替换不为空的
                if (map.get(driverListTemp.get(i).getKabnum()).getGpstime() == null) {
                    map.put(driverListTemp.get(i).getKabnum(), driverListTemp.get(i));
                } else {
                    //如果集合里的gps时间小于新的同一台车的其他时间gps时间进行替换
                    if (driverListTemp.get(i).getGpstime() != null) {
                        //                        System.out.println("原来一个--  > "+map.get(driverListTemp.get(i).getKabnum()).getGpstime().getTime());
                        //                        System.out.println("新------ - > "+driverListTemp.get(i).getGpstime().getTime());
                        if (map.get(driverListTemp.get(i).getKabnum()).getGpstime().getTime() < driverListTemp.get(i)
                                .getGpstime()
                                .getTime()) {
                            map.put(driverListTemp.get(i).getKabnum(), driverListTemp.get(i));
                        }
                    }
                }
            }

        }
        //把map 转换成list
        List<Driver> driverList = new ArrayList<Driver>();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            driverList.add(map.get(key));
        }

        DefaultPosition dp = findDefaultPosition();
        if (!S.isNull(dp)) {
            lg = dp.getDeflg();
            lt = dp.getDeflt();
            gpstime = dp.getGpstime();
        }
        //把没有经纬度的车辆加经纬度，有经纬度转百度坐标
        if (!S.isNull(driverList) && driverList.size() > 0) {
            for (Driver d : driverList) {
                if (d.getLastlt() == null && d.getLastlg() == null) {
                    //设置默认经纬度
                    d.setLastlt(lt);
                    d.setLastlg(lg);
                    d.setGpstime(gpstime);

                }
                //                else{
                //                    GpsEntity gpsEntity = ChangeGps.wgs84Tobd09(d.getLastlt(),d.getLastlg());
                //                    if (!S.isNull(gpsEntity)){
                //                        d.setLastlg(gpsEntity.getLongitude());
                //                        d.setLastlt(gpsEntity.getLatitude());
                //                    }else{
                //                        //System.out.println(d.getName()+"转换失败！");
                //                    }
                //                }
            }
        }

        Collections.sort(driverList);
        return driverList;
    }

    public DefaultPosition findDefaultPosition() {
        DetachedCriteria dc = DetachedCriteria.forClass(DefaultPosition.class);
        dc.add(Restrictions.eq("ssid", 1002));
        dc.add(Restrictions.eq("userId", 0));
        return defaultPositionDao.findByDetachedCriteriaObj(dc);
    }


    public List<Driver> findListByIDS(Integer[] ids) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Driver.class);
        criteria.add(Restrictions.in("driverid", ids));
        List<Driver> drivers = driverDao.findByDetachedCriteria(criteria);
        return drivers;
    }

    @Override
    public List<Driver> findDriverremainByClientId(Integer clientid) {
        DetachedCriteria dc = DetachedCriteria.forClass(Driver.class);
        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));

        }
        dc.add(Restrictions.eq("remain", 0));
        dc.addOrder(Order.desc("kabnum"));
        return driverDao.findByDetachedCriteria(dc);
    }

    @Override
    public Number findCount(Integer clientid) {

        String sql = "select count(id) from tab_driver where clientid=" + clientid;
        return driverDao.findCount(sql);
    }

    @Override
    public Number findCount( ) {

        String sql = "select count(id) from tab_driver";
        return driverDao.findCount(sql);
    }

}
