package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CallBussStatDao;
import com.spring.jersy.hibernate.model.entity.CallBussStat;
import com.spring.jersy.hibernate.model.service.CallBussStatService;
import com.spring.jersy.hibernate.publics.bean.MonitorBean;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.spring.jersy.hibernate.model.service.impl.CallBussServiceImpl.StrToDate;

/**
 * Created by Administrator on 2016/9/19.
 */
@Service
public class CallBussStatServiceImpl implements CallBussStatService {

    @Autowired
    private CallBussStatDao callBussStatDao;

    //新电召单
    public static StringBuffer CallBussStatStatistical(int length) {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT allorder,cancelorder,finishorder,neatnotcar,neworder,processingorder,outtimeorder,onlinecar,offlinecar,time FROM `tab_callbuss_stat` ORDER BY time DESC LIMIT " + length);
        return sqllsit;

    }

    //新电召单//'状态: 0新业务 1:已下呼 2:已租车 3:已取消 4:已完成',5,附近没车
    public static StringBuffer CallBussStatStatisticalSql(int clientid) {
        Integer orderovertime = 30;

        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT COUNT(billid), ");
        sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` p WHERE p.`status` = 3 AND p.calltime > date(NOW()) AND enterpriseid=" + clientid + "),  ");
        sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` p WHERE p.`status` = 4 AND p.calltime > date(NOW()) AND enterpriseid=" + clientid + ") , ");
        sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` p WHERE p.`status` = 5 AND p.calltime > date(NOW()) AND enterpriseid=" + clientid + ") , ");
        sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` p WHERE (p.`status` =0 OR p.`status` = 1) AND p.calltime > date(NOW()) AND enterpriseid=" + clientid + "), ");
        sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` p WHERE p.`status` = 2 AND p.calltime > date(NOW()) AND enterpriseid=" + clientid + ") , ");
        sqllsit.append(" ( SELECT COUNT(count)  FROM (SELECT TIMESTAMPDIFF(MINUTE,calltime, now()) as count FROM tab_phonecallbuss  WHERE calltime > date(NOW()) and enterpriseid=" + clientid + " AND (`status` =0 OR `status` = 1))  t where t.count>" + orderovertime + " ) ,  ");
        sqllsit.append(" ( SELECT COUNT(DISTINCT kabnum) FROM `tab_driver` WHERE isonline=1 AND clientid=" + clientid + " ) , ");
        //        sqllsit.append(" ( SELECT COUNT(DISTINCT kabnum) FROM `tab_driver` WHERE isonline=0  AND clientid="+clientid+" ), " );
        sqllsit.append(" ( SELECT ( SELECT COUNT(DISTINCT kabnum) FROM `tab_driver` WHERE clientid = " + clientid + " ) - (SELECT COUNT(DISTINCT kabnum) FROM `tab_driver` WHERE isonline = 1 AND clientid = " + clientid + ") ), ");
        sqllsit.append(" date(NOW())  ");
        sqllsit.append(" FROM tab_phonecallbuss  ");
        sqllsit.append(" WHERE calltime > date(NOW()) AND enterpriseid=" + clientid);

        return sqllsit;

    }

    public static StringBuffer MontiorSql(int clientid) {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT IFNULL(t1.billidnum,0),IFNULL(t1.going,0),t2.accountnum,t2.onffline,t2.clientid FROM ");
        sqllsit.append(" (SELECT COUNT(billid)AS billidnum,SUM(`status`=2) AS going,enterpriseid FROM tab_phonecallbuss WHERE calltime>DATE(NOW()) AND enterpriseid IS NOT NULL GROUP BY enterpriseid) t1 ");
        sqllsit.append("  RIGHT JOIN ");
        sqllsit.append(" (SELECT COUNT(DISTINCT kabnum) AS accountnum,SUM(isonline=1) AS onffline ,clientid FROM tab_driver WHERE clientid IS NOT NULL GROUP BY clientid) t2 ");
        sqllsit.append(" ON t1.enterpriseid  = t2.clientid ");
        sqllsit.append(" WHERE clientid =" + clientid);

        return sqllsit;

    }

    @Override
    public List<CallBussStat> findList() {
        DetachedCriteria dc = DetachedCriteria.forClass(CallBussStat.class);
        return callBussStatDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<CallBussStat> findLastCallBussStat(int length, int clientid) {
        StringBuffer sqllsit = null;
        if (clientid > 0) {
            sqllsit = CallBussStatStatisticalSql(clientid);
        } else {
            sqllsit = CallBussStatStatistical(length);
        }
        //        allorder,cancelorder,finishorder,neatnotcar,neworder,outtimeorder,processingorder,onlinecar,offlinecar
        List<Object[]> list = callBussStatDao.findListSql(String.valueOf(sqllsit));
        List<CallBussStat> callBusslist = new ArrayList<CallBussStat>();
        CallBussStat callBean;
        for (Object[] objects : list) {
            callBean = new CallBussStat();
            callBean.setAllorder(objects[0] == null ? 0 : Integer.parseInt(objects[0].toString()));
            callBean.setCancelorder(objects[1] == null ? 0 : Integer.parseInt(objects[1].toString()));
            callBean.setFinishorder(objects[2] == null ? 0 : Integer.parseInt(objects[2].toString()));
            callBean.setNeatnotcar(objects[3] == null ? 0 : Integer.parseInt(objects[3].toString()));
            callBean.setNeworder(objects[4] == null ? 0 : Integer.parseInt(objects[4].toString()));
            callBean.setProcessingorder(objects[5] == null ? 0 : Integer.parseInt(objects[5].toString()));
            callBean.setOuttimeorder(objects[6] == null ? 0 : Integer.parseInt(objects[6].toString()));
            callBean.setOnlinecar(objects[7] == null ? 0 : Integer.parseInt(objects[7].toString()));
            callBean.setOfflinecar(objects[8] == null ? 0 : Integer.parseInt(objects[8].toString()));

            if (clientid != 0) {
                callBean.setTime(objects[9] == null ? null : new Date());
            } else {
                callBean.setTime(objects[9] == null ? null : StrToDate(objects[9].toString()));
            }
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<MonitorBean> findLastMonitor(int clientid) {
        StringBuffer sqllsit = null;
        List<MonitorBean> callBusslist = new ArrayList<MonitorBean>();
        MonitorBean callBean;


        if (clientid > 0) {
            sqllsit = MontiorSql(clientid);
            List<Object[]> list = callBussStatDao.findListSql(String.valueOf(sqllsit));
            //        SELECT IFNULL(t1.billidnum,0),IFNULL(t1.going,0),t2.accountnum,t2.onffline,t2.clientid
            for (Object[] objects : list) {
                callBean = new MonitorBean();
                callBean.setAllbill(objects[0] == null ? 0 : Integer.parseInt(objects[0].toString()));
                callBean.setPassenger(objects[1] == null ? 0 : Integer.parseInt(objects[1].toString()));
                callBean.setCallnum(objects[2] == null ? 0 : Integer.parseInt(objects[2].toString()));
                callBean.setOnline(objects[3] == null ? 0 : Integer.parseInt(objects[3].toString()));
                callBean.setEmpty(callBean.getOnline() - callBean.getPassenger());
                callBean.setMalfunction(0);
                callBusslist.add(callBean);
            }
        } else {
            sqllsit = CallBussStatStatistical(1);
            List<Object[]> list = callBussStatDao.findListSql(String.valueOf(sqllsit));
            //        SELECT IFNULL(t1.billidnum,0),IFNULL(t1.going,0),t2.accountnum,t2.onffline,t2.clientid
            for (Object[] objects : list) {
                callBean = new MonitorBean();
                callBean.setAllbill(objects[0] == null ? 0 : Integer.parseInt(objects[0].toString()));
                callBean.setPassenger(objects[5] == null ? 0 : Integer.parseInt(objects[5].toString()));
                callBean.setCallnum(Integer.parseInt(objects[7].toString()) + Integer.parseInt(objects[8].toString()));
                callBean.setOnline(Integer.parseInt(objects[7].toString()));
                callBean.setEmpty(callBean.getOnline() - callBean.getPassenger());
                callBean.setMalfunction(0);
                callBusslist.add(callBean);
            }
        }

        return callBusslist;
    }

}
