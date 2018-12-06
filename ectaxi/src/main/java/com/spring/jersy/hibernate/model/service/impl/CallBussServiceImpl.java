package com.spring.jersy.hibernate.model.service.impl;


import com.spring.jersy.hibernate.model.dao.CallBussDao;
import com.spring.jersy.hibernate.model.entity.*;
import com.spring.jersy.hibernate.model.service.CallBussService;
import com.spring.jersy.hibernate.publics.bean.*;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/4.
 */
@Service
public class CallBussServiceImpl implements CallBussService {

    @Resource
    private CallBussDao callBussDao;

    public static StringBuffer OperationDateReport(String begintime, String endtime) {
        StringBuffer sqllsit = new StringBuffer();
        if (begintime == null && endtime == null) {
            sqllsit.append(" SELECT substr(p.geton, 1, 10), COUNT(orderid), SUM(p.mileage), SUM(p.money), SUM( TIMESTAMPDIFF(SECOND, p.geton, p.getoff)), COUNT(DISTINCT account) FROM `tab_payrecords` p ");
            sqllsit.append(" GROUP BY substr(p.geton, 1, 10) ");
        } else {

            sqllsit.append(" SELECT substr(p.geton, 1, 10), COUNT(orderid), SUM(p.mileage), SUM(p.money), SUM( TIMESTAMPDIFF(SECOND, p.geton, p.getoff)), COUNT(DISTINCT account) FROM `tab_payrecords` p ");

            if (begintime != null && endtime != null) {

                sqllsit.append(" WHERE p.geton  >" + "'" + begintime + "'" + " AND p.geton < " + "'" + endtime + "'");


            }
            if (begintime != null && endtime == null) {
                sqllsit.append(" WHERE p.geton >" + "'" + begintime + "'");

            }
            if (begintime == null && endtime != null) {
                sqllsit.append(" WHERE p.geton < " + "'" + endtime + "'");

            }
            sqllsit.append(" GROUP BY substr(p.geton, 1, 10) ");
        }
        return sqllsit;
    }

    public static StringBuffer PayMentReport(String begintime, String endtime) {
        StringBuffer sqllsit = new StringBuffer();
        if (begintime == null && endtime == null) {
            sqllsit.append(" SELECT p.orderid,p.geton,p.getoff,d.name,d.account,d.kabnum,d.drivercardid,SUM(p.mileage),SUM(p.money)  FROM tab_payrecords p  LEFT JOIN tab_driver d ON p.account =d.account ");
            sqllsit.append(" GROUP BY p.orderid ORDER BY SUM(p.mileage) DESC ");
        } else {

            sqllsit.append(" SELECT p.orderid,p.geton,p.getoff,d.name,d.account,d.kabnum,d.drivercardid,SUM(p.mileage),SUM(p.money)  FROM tab_payrecords p  LEFT JOIN tab_driver d ON p.account =d.account ");

            if (begintime != null && endtime != null) {

                sqllsit.append(" WHERE  p.geton >" + "'" + begintime + "'" + " AND p.getoff < " + "'" + endtime + "'");


            }
            if (begintime != null && endtime == null) {
                sqllsit.append(" WHERE  p.geton>" + "'" + begintime + "'");

            }
            if (begintime == null && endtime != null) {
                sqllsit.append(" WHERE  p.getoff < " + "'" + endtime + "'");

            }
            sqllsit.append(" GROUP BY p.orderid ORDER BY SUM(p.mileage) DESC ");
        }
        return sqllsit;
    }

    public static StringBuffer DrivergetOnOff(String begintime, String endtime) {
        StringBuffer sqllsit = new StringBuffer();
        if (begintime == null && endtime == null) {
            sqllsit.append(" SELECT wd.drivername,wd.ontime,wd.offtime,wd.workleng,wd.tomileage,wd.tomoney,dr.kabnum,dr.`name`,dr.drivercardid ");
            sqllsit.append(" FROM (SELECT workrecords.drivername,workrecords.ontime,workrecords.offtime,workrecords.workleng,SUM(p.mileage) AS tomileage,SUM(p.money) AS tomoney ");
            sqllsit.append(" FROM (SELECT w1.account AS drivername ,MIN(w1.time) as ontime, MAX(w2.time) as offtime,TIMESTAMPDIFF(SECOND,MIN(w1.time),MAX(w2.time)) AS workleng ");
            sqllsit.append(" FROM (SELECT * FROM tab_workrecords WHERE type=0) w1 LEFT JOIN (SELECT * FROM tab_workrecords WHERE type=1) w2 ON w1.account=w2.account GROUP BY w1.account) workrecords ");
            sqllsit.append(" LEFT JOIN tab_payrecords p ");
            sqllsit.append(" ON workrecords.drivername = p.account ");
            sqllsit.append(" GROUP BY workrecords.drivername ) wd  ");
            sqllsit.append(" LEFT JOIN tab_driver dr ON wd.drivername = dr.account ORDER BY wd.workleng DESC  ");
        } else {

            sqllsit.append(" SELECT wd.drivername,wd.ontime,wd.offtime,wd.workleng,wd.tomileage,wd.tomoney,dr.kabnum,dr.`name`,dr.drivercardid ");
            sqllsit.append(" FROM (SELECT workrecords.drivername,workrecords.ontime,workrecords.offtime,workrecords.workleng,SUM(p.mileage) AS tomileage,SUM(p.money) AS tomoney ");
            sqllsit.append(" FROM (SELECT w1.account AS drivername ,MIN(w1.time) as ontime, MAX(w2.time) as offtime,TIMESTAMPDIFF(SECOND,MIN(w1.time),MAX(w2.time)) AS workleng ");
            sqllsit.append(" FROM (SELECT * FROM tab_workrecords WHERE type=0) w1 LEFT JOIN (SELECT * FROM tab_workrecords WHERE type=1) w2 ON w1.account=w2.account GROUP BY w1.account) workrecords ");
            sqllsit.append(" LEFT JOIN tab_payrecords p ");
            sqllsit.append(" ON workrecords.drivername = p.account ");

            if (begintime != null && endtime != null) {

                sqllsit.append(" AND geton>" + "'" + begintime + "'" + " AND getoff < " + "'" + endtime + "'");
                sqllsit.append(" GROUP BY workrecords.drivername ) wd  ");
                sqllsit.append(" LEFT JOIN tab_driver dr ON wd.drivername = dr.account   ");
                sqllsit.append(" WHERE wd.ontime>" + "'" + begintime + "'" + " AND wd.offtime< " + "'" + endtime + "'");

            }
            if (begintime != null && endtime == null) {
                sqllsit.append(" AND geton>" + "'" + begintime + "'");
                sqllsit.append(" GROUP BY workrecords.drivername ) wd  ");
                sqllsit.append(" LEFT JOIN tab_driver dr ON wd.drivername = dr.account   ");
                sqllsit.append(" WHERE wd.ontime>" + "'" + begintime + "'");

            }
            if (begintime == null && endtime != null) {
                sqllsit.append(" AND getoff < " + "'" + endtime + "'");
                sqllsit.append(" GROUP BY workrecords.drivername ) wd  ");
                sqllsit.append(" LEFT JOIN tab_driver dr ON wd.drivername = dr.account   ");
                sqllsit.append(" WHERE wd.ontime < " + "'" + endtime + "'");

            }
            sqllsit.append(" ORDER BY wd.workleng DESC ");
        }
        return sqllsit;
    }

    //新电召单
    public static StringBuffer CallBussNewStatistical(String begintime, int length, int clientid) {
        StringBuffer sqllsit = new StringBuffer();
        if (clientid != 0 && begintime != null) {
            sqllsit.append(" SELECT billid,`status`,calltime,address,clientmobile,srcaddr,ordertype   ,(SELECT TIMESTAMPDIFF(MINUTE,calltime, now())) as countjet,remark,msid ,enterpriseid FROM tab_phonecallbuss  ");
            sqllsit.append(" WHERE calltime > " + "'" + begintime + "'   AND (`status` =0 OR `status` = 1) and enterpriseid =" + clientid + "  ORDER BY countjet limit " + length);
        } else {
            sqllsit.append(" SELECT billid,`status`,calltime,address,clientmobile,srcaddr,ordertype   ,(SELECT TIMESTAMPDIFF(MINUTE,calltime, now())) as countjet,remark,msid ,enterpriseid FROM tab_phonecallbuss  ");
            sqllsit.append(" WHERE calltime > " + "'" + begintime + "'   AND (`status` =0 OR `status` = 1) ORDER BY countjet limit " + length);
        }
        return sqllsit;

    }

    //历史
    public static StringBuffer CallBussHistoryStatistical(String begintime, int length, int clientid) {
        StringBuffer sqllsit = new StringBuffer();
        if (clientid != 0 && begintime != null) {
            sqllsit.append(" SELECT p.billid, p.`status`, p.calltime, p.address, p.clientmobile, p.carbox, p.srcaddr, p.ordertype, ( SELECT TIMESTAMPDIFF(MINUTE, calltime, now())) AS countjet, p.remark, p.msid, d.phone,  d.`name` , p.enterpriseid FROM tab_phonecallbuss p LEFT JOIN tab_driver d ON p.msid = d.msid    ");
            sqllsit.append(" WHERE p.calltime > " + "'" + begintime + "' AND p.`status` <>0 AND p.`status` <> 1 AND p.`status` <> 2 and enterpriseid =" + clientid + " ORDER BY countjet limit " + length);
        } else {
            sqllsit.append(" SELECT p.billid, p.`status`, p.calltime, p.address, p.clientmobile, p.carbox, p.srcaddr, p.ordertype, ( SELECT TIMESTAMPDIFF(MINUTE, calltime, now())) AS countjet, p.remark, p.msid, d.phone,  d.`name` , p.enterpriseid FROM tab_phonecallbuss p LEFT JOIN tab_driver d ON p.msid = d.msid    ");
            sqllsit.append(" WHERE p.calltime > " + "'" + begintime + "' AND p.`status` <>0 AND p.`status` <> 1 AND p.`status` <> 2  ORDER BY countjet limit " + length);
        }
        return sqllsit;
    }

    //处理中
    public static StringBuffer CallBussProStatistical(String begintime, int length, int clientid) {
        StringBuffer sqllsit = new StringBuffer();
        if (clientid != 0 && begintime != null) {
            sqllsit.append(" SELECT p.billid, p.`status`, p.calltime, p.address, p.clientmobile, p.srcaddr, p.ordertype, ( SELECT TIMESTAMPDIFF(MINUTE, calltime, now())) AS countjet, p.remark, p.msid, d.phone, d.`name`, d.kabnum, p.enterpriseid FROM tab_phonecallbuss p LEFT JOIN tab_driver d ON p.msid = d.msid   ");
            sqllsit.append(" WHERE p.calltime > " + "'" + begintime + "'   AND (p.`status` =2 ) and enterpriseid =" + clientid + " ORDER BY countjet limit " + length);
        } else {
            sqllsit.append(" SELECT p.billid, p.`status`, p.calltime, p.address, p.clientmobile, p.srcaddr, p.ordertype, ( SELECT TIMESTAMPDIFF(MINUTE, calltime, now())) AS countjet, p.remark, p.msid, d.phone, d.`name`, d.kabnum, p.enterpriseid FROM tab_phonecallbuss p LEFT JOIN tab_driver d ON p.msid = d.msid   ");
            sqllsit.append(" WHERE p.calltime > " + "'" + begintime + "'   AND (p.`status` =2 )  ORDER BY countjet limit " + length);
        }
        return sqllsit;


    }

    //
    public static StringBuffer CallBussByPhoneKabnum(String phone, String kabnum) {
        StringBuffer sqllsit = new StringBuffer();
        if (!S.isNull(phone) && !S.isNull(kabnum)) {
            sqllsit.append(" SELECT billid,opruser,callnumber,clientname,clientsex,clientmobile,carbox,ordertype FROM `tab_phonecallbuss` WHERE carbox = '" + kabnum + "' AND clientmobile = '" + phone + "' ORDER BY calltime DESC LIMIT 1 ");
        }
        return sqllsit;


    }

    public static StringBuffer CallBussRePortInfo(String begintime) {
        StringBuffer sqllsit = new StringBuffer();
        if (begintime != null) {
            sqllsit.append(" SELECT COUNT(billid) ,");
            sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` =0 OR `status` = 1) and  calltime >" + "'" + begintime + "'" + ") , ");
            sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE `status` = 2 and  calltime >" + "'" + begintime + "'" + ") , ");
            sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE `status` = 3 and  calltime >" + "'" + begintime + "'" + ") , ");
            sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE `status` = 4 and  calltime >" + "'" + begintime + "'" + ") , ");
            sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE `status` = 5 and  calltime >" + "'" + begintime + "'" + ") , ");
            sqllsit.append(" ( select COUNT(count) from (SELECT TIMESTAMPDIFF(MINUTE,calltime, now()) as count FROM tab_phonecallbuss  WHERE calltime > " + "'" + begintime + "'" + " AND (`status` =0 OR `status` = 1))  t where t.count>=15)  ");
            sqllsit.append("  FROM tab_phonecallbuss ");
            sqllsit.append(" WHERE calltime > " + "'" + begintime + "'");
        }
        return sqllsit;


    }

    public static StringBuffer CallBussEvaluate(String begintime, String endtime) {
        StringBuffer sqllsit = new StringBuffer();
        if (begintime == null && endtime == null) {
            sqllsit.append(" SELECT COUNT(billid) , ");
            sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) ) , ");
            sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND evaluate=1 ), ");
            sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND (evaluate=2 OR evaluate=3 OR evaluate=4) ), ");
            sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND evaluate=5 ) , ");
            sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND evaluate IS NULL ) ");
            sqllsit.append(" FROM tab_phonecallbuss   ");
        } else {
            sqllsit.append(" SELECT COUNT(billid) , ");

            if (begintime != null && endtime != null) {
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2)  and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND evaluate=1  and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND (evaluate=2 OR evaluate=3 OR evaluate=4)  and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND evaluate=5 and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND evaluate IS NULL and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ")  ");
                sqllsit.append(" FROM tab_phonecallbuss ");
                sqllsit.append(" WHERE calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'");
            }
            if (begintime != null && endtime == null) {
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2)  and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND evaluate=1  and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND (evaluate=2 OR evaluate=3 OR evaluate=4)  and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND evaluate=5 and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND evaluate IS NULL  and calltime >" + "'" + begintime + "'" + ")  ");
                sqllsit.append(" FROM tab_phonecallbuss  ");
                sqllsit.append(" WHERE calltime > " + "'" + begintime + "'");
            }
            if (begintime == null && endtime != null) {
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2)  and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND evaluate=1  and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND (evaluate=2 OR evaluate=3 OR evaluate=4)  and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND evaluate=5 and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (`status` = 4 OR `status` = 2) AND evaluate IS NULL and  calltime <" + "'" + endtime + "'" + ")  ");
                sqllsit.append(" FROM tab_phonecallbuss ");
                sqllsit.append(" WHERE calltime <" + "'" + endtime + "'");
            }
        }
        return sqllsit;
    }

    public static StringBuffer CallBussRePort(String begintime, String endtime) {
        StringBuffer sqllsit = new StringBuffer();
        if (begintime == null && endtime == null) {
            sqllsit.append(" SELECT COUNT(billid), ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4)) , ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`= 3 )  , ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 )  ");
            sqllsit.append("  FROM tab_phonecallbuss ");
        } else {
            sqllsit.append(" SELECT COUNT(billid), ");

            if (begintime != null && endtime != null) {
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ")  ");
                sqllsit.append("  FROM tab_phonecallbuss ");
                sqllsit.append(" WHERE calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'");
            }
            if (begintime != null && endtime == null) {
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and  calltime >" + "'" + begintime + "'" + ")  ");
                sqllsit.append("  FROM tab_phonecallbuss ");
                sqllsit.append(" WHERE calltime > " + "'" + begintime + "'");
            }
            if (begintime == null && endtime != null) {
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4)  and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and  calltime <" + "'" + endtime + "'" + ")  ");
                sqllsit.append("  FROM tab_phonecallbuss ");
                sqllsit.append(" WHERE calltime <" + "'" + endtime + "'");
            }
        }
        return sqllsit;


    }

    public static StringBuffer PassCallBussRePort(String begintime, String endtime) {
        StringBuffer sqllsit = new StringBuffer();
        if (begintime == null && endtime == null) {
            sqllsit.append(" SELECT o.opruser ,COUNT(billid) , ");
            sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (ordertype = 0) AND opruser = o.opruser  ), ");
            sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (ordertype = 1) AND opruser = o.opruser  ), ");
            sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (ordertype = 2) AND opruser = o.opruser  ), ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser) , ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser) , ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser) , ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser AND ordertype = 0) , ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser AND ordertype = 0) , ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser AND ordertype = 0) , ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser AND ordertype = 1) , ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser AND ordertype = 1) , ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser AND ordertype = 1) , ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser AND ordertype = 2) , ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser AND ordertype = 2) , ");
            sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser AND ordertype = 2)  ");
            sqllsit.append(" FROM tab_phonecallbuss o ");
            sqllsit.append(" WHERE o.opruser<>''");
            sqllsit.append(" GROUP BY opruser ");
            sqllsit.append(" ORDER BY COUNT(opruser) DESC ");
        } else {
            sqllsit.append(" SELECT o.opruser ,COUNT(opruser) , ");

            if (begintime != null && endtime != null) {
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (ordertype = 0) AND opruser = o.opruser  and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (ordertype = 1) AND opruser = o.opruser  and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (ordertype = 2) AND opruser = o.opruser  and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser AND ordertype = 0 and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser AND ordertype = 0 and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser AND ordertype = 0 and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser AND ordertype = 1 and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser AND ordertype = 1 and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser AND ordertype = 1 and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser AND ordertype = 2 and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser AND ordertype = 2 and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser AND ordertype = 2 and  calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'" + ")  ");
                sqllsit.append(" FROM tab_phonecallbuss o ");
                sqllsit.append(" WHERE calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "' AND o.opruser<> '' ");
            }
            if (begintime != null && endtime == null) {
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (ordertype = 0) AND opruser = o.opruser  and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (ordertype = 1) AND opruser = o.opruser  and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (ordertype = 2) AND opruser = o.opruser  and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser AND ordertype = 0 and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser AND ordertype = 0 and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser AND ordertype = 0 and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser AND ordertype = 1 and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser AND ordertype = 1 and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser AND ordertype = 1 and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser AND ordertype = 2 and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser AND ordertype = 2 and  calltime >" + "'" + begintime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser AND ordertype = 2 and  calltime >" + "'" + begintime + "'" + ")  ");
                sqllsit.append(" FROM tab_phonecallbuss o ");
                sqllsit.append(" WHERE calltime > " + "'" + begintime + "' AND o.opruser<> '' ");
            }
            if (begintime == null && endtime != null) {
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (ordertype = 0) AND opruser = o.opruser  and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (ordertype = 1) AND opruser = o.opruser  and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" ( SELECT COUNT(billid) FROM `tab_phonecallbuss` WHERE (ordertype = 2) AND opruser = o.opruser  and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser AND ordertype = 0 and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser AND ordertype = 0 and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser AND ordertype = 0 and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser AND ordertype = 1 and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser AND ordertype = 1 and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser AND ordertype = 1 and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE (`status`< 3 or `status`>4) and opruser=o.opruser AND ordertype = 2 and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=3 and opruser=o.opruser AND ordertype = 2 and  calltime <" + "'" + endtime + "'" + ") , ");
                sqllsit.append(" (SELECT COUNT(billid) FROM `tab_phonecallbuss`WHERE `status`=4 and opruser=o.opruser AND ordertype = 2 and  calltime <" + "'" + endtime + "'" + ") ");
                sqllsit.append(" FROM tab_phonecallbuss o ");
                sqllsit.append(" WHERE calltime <" + "'" + endtime + "' AND o.opruser<> '' ");
            }


            sqllsit.append(" GROUP BY opruser ");
            sqllsit.append(" ORDER BY COUNT(opruser) DESC ");
        }
        return sqllsit;
        //        //System.out.println(sqllsit);

    }

    public static StringBuffer DriverCallBussRePort(String begintime, String endtime, Integer clientid) {

        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT t1.account,t1.`name`, t1.msid,t1.clientid ,IFNULL(t2.allorder,0),IFNULL(t2.unfish,0),IFNULL(t2.successorder,0),IFNULL(t2.cancelorder,0) FROM `tab_driver` t1 ");
        sqllsit.append(" LEFT JOIN ");
        sqllsit.append(" (SELECT  o.msid, COUNT(o.opruser) AS allorder, SUM( `status` < 3 OR `status` > 4 ) AS unfish, SUM(`status` = 4 ) AS successorder, SUM( `status` = 3 ) AS cancelorder ");

        sqllsit.append(" FROM tab_phonecallbuss o ");
        if (begintime != null && endtime != null) {
            sqllsit.append(" WHERE calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "' AND o.msid<>''");
        }

        sqllsit.append(" GROUP BY msid ");
        sqllsit.append(" ORDER BY COUNT(msid) DESC ) t2 ");
        sqllsit.append(" ON t1.msid = t2.msid ");
        if (clientid > 0) {
            sqllsit.append(" WHERE clientid = " + clientid);
        }

        return sqllsit;

    }

    public static StringBuffer DateCallBussRePort(String begintime, String endtime, Integer clientid) {
        StringBuffer sqllsit = new StringBuffer();
        if (begintime != null && endtime != null) {
            sqllsit.append(" SELECT substr(t.calltime, 1, 10), count(billid),  SUM( `status` < 3 OR `status` > 4 ) AS unfish, SUM(`status` = 4 ) AS successorder, SUM( `status` = 3 ) AS cancelorder ");
            sqllsit.append(" FROM tab_phonecallbuss t ");
            sqllsit.append(" WHERE calltime >" + "'" + begintime + "'" + " AND calltime < " + "'" + endtime + "'");
            if (clientid > 0) {
                sqllsit.append(" AND enterpriseid = " + clientid);
            }
            sqllsit.append(" group by substr(t.calltime,1,10) ");
        }
        return sqllsit;

    }

    public static StringBuffer SeatBussRePort(String begintime, String endtime, Integer clientid) {
        StringBuffer sqllsit = new StringBuffer();
        if (begintime != null && endtime != null) {
            sqllsit.append(" SELECT t1.account,t1.`name`,IFNULL(t2.allorder,0),IFNULL(t2.unfish,0),IFNULL(t2.successorder,0),IFNULL(t2.cancelorder,0),t1.clientid ");
            sqllsit.append(" FROM `tab_seats` t1 ");
            sqllsit.append(" LEFT JOIN ");
            sqllsit.append(" (SELECT  o.opruser AS account, COUNT(o.opruser) AS allorder, ");
            sqllsit.append(" SUM( `status` < 3 OR `status` > 4 ) AS unfish, ");
            sqllsit.append(" SUM(`status` = 4 ) AS successorder, ");
            sqllsit.append(" SUM( `status` = 3 ) AS cancelorder ");
            sqllsit.append(" FROM tab_phonecallbuss o ");
            sqllsit.append(" WHERE o.calltime >'" + begintime + "' and o.calltime <'" + endtime + "' ");

            sqllsit.append(" GROUP BY o.opruser ");
            sqllsit.append(" ORDER BY COUNT(o.opruser) DESC) t2 ");
            sqllsit.append("  ON t1.opruser = t2.account  ");
            if (clientid > 0) {
                sqllsit.append("  WHERE clientid= " + clientid);

            }
            sqllsit.append(" ORDER BY t2.allorder DESC ");
        } else {
            sqllsit.append("");
        }
        //System.out.println(sqllsit);
        return sqllsit;


    }

    public static StringBuffer PassengBussRePort(String begintime, String endtime, Integer clientid) {
        StringBuffer sqllsit = new StringBuffer();
        if (begintime != null && endtime != null) {
            sqllsit.append(" SELECT p.mobile ,p.`name`,IFNULL(passorder.allorder,0),0,IFNULL(passorder.successorder,0) ,IFNULL(passorder.cancelorder,0) ,passorder.clientid ");
            sqllsit.append(" FROM tab_phoneuser p ");
            sqllsit.append(" LEFT JOIN (SELECT o.opruser AS passname,  COUNT(opruser) AS allorder,SUM(`status` = 4) AS successorder, SUM(`status` = 3) AS cancelorder, o.enterpriseid AS clientid FROM tab_phonecallbuss o ");
            sqllsit.append(" WHERE o.enterpriseid IS NOT NULL  AND o.calltime >'" + begintime + "' and o.calltime <'" + endtime + "' ");
            sqllsit.append("  GROUP BY opruser ORDER BY COUNT(opruser) DESC ) passorder ");
            sqllsit.append(" ON passorder.passname =  p.`name` ");
            sqllsit.append("  WHERE passorder.clientid IS NOT NULL ");
            if (clientid > 0) {
                sqllsit.append("  AND passorder.clientid= " + clientid);
            }
        } else {
            sqllsit.append("");
        }
        //System.out.println(sqllsit);
        return sqllsit;


    }

    /**
     * 运营详细收入
     *
     * @param begintime 电召单时间
     * @param endtime
     * @return
     */
    public static StringBuffer DriverOperateDeatails(String begintime, String endtime, int clientid) {
        StringBuffer sqllsit = new StringBuffer();

        sqllsit.append(" SELECT t2.account,t3.carbox,t3.calltime,t2.geton,t2.getoff,IFNULL(t3.enterpriseid,0) as clientid,t2.mileage,t2.vainmileage,t2.money,IFNULL(t3.evaluate,3) AS eva FROM tab_phonecallbuss t3 ");
        sqllsit.append(" INNER JOIN  tab_payrecords t2 ");
        sqllsit.append(" ON t3.billid = t2.orderid ");
        if (!S.isNull(begintime) && !S.isNull(endtime)) {
            sqllsit.append(" WHERE t3.calltime >'" + begintime + "' and t3.calltime <'" + endtime + "' ");
            if (clientid > 0) {
                sqllsit.append(" and t3.enterpriseid = " + clientid);
            }
        }
        //System.out.println(sqllsit);
        return sqllsit;


    }

    /**
     * 乘客统计详细
     *
     * @param begintime 电召单时间
     * @param endtime
     * @return
     */
    public static StringBuffer PassPayDetail(String begintime, String endtime, int clientid) {

        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT t3.clientmobile,t3.clientname,t2.money,t2.money as mom,t2.extramoney,t2.paytype,t3.calltime,t2.account,t3.carbox,t3.billid,t2.tradeno,t3.enterpriseid FROM tab_phonecallbuss t3 ");
        sqllsit.append(" INNER  JOIN  tab_payrecords t2 ");
        sqllsit.append(" ON t3.billid = t2.orderid ");
        sqllsit.append(" WHERE t2.paytime AND clientmobile IS NOT NULL ");
        if (!S.isNull(begintime) && !S.isNull(endtime)) {
            sqllsit.append(" and t3.calltime >'" + begintime + "' and t3.calltime <'" + endtime + "' ");
            if (clientid > 0) {
                sqllsit.append(" and t3.enterpriseid = " + clientid);
            }
        }
        sqllsit.append("  ORDER BY calltime DESC ");
        //System.out.println(sqllsit);
        return sqllsit;


    }

    /**
     * 司机收入流水
     *
     * @param begintime 电召单时间
     * @param endtime
     * @return
     */
    public static StringBuffer DriverIncomeList(String begintime, String endtime, int clientid) {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT t3.msid,t2.account,t2.money,t2.money as bill,t2.extramoney,t2.paytype,t2.paytime,t3.carbox,t3.clientname,t3.clientmobile,t3.billid,t3.enterpriseid FROM tab_phonecallbuss t3 ");
        sqllsit.append(" INNER  JOIN  tab_payrecords t2 ");
        sqllsit.append(" ON t3.billid = t2.orderid ");
        sqllsit.append(" WHERE t2.paytime IS NOT NULL ");
        if (!S.isNull(begintime) && !S.isNull(endtime)) {
            sqllsit.append(" and t2.paytime >'" + begintime + "' and t2.paytime <'" + endtime + "' ");
            if (clientid > 0) {
                sqllsit.append(" and t3.enterpriseid = " + clientid);
            }
        }
        //System.out.println(sqllsit);
        return sqllsit;


    }

    /**
     * 司机收入明细
     *
     * @param begintime 电召单时间
     * @param endtime
     * @return
     */
    public static StringBuffer DriverIncomeDetail(String begintime, String endtime, int clientid) {
        StringBuffer sqllsit = new StringBuffer();

        sqllsit.append(" SELECT t2.paytime,t2.account,sum(t2.money),t3.msid,t3.carbox,t3.clientname ,COUNT(t2.account),t3.enterpriseid  FROM tab_phonecallbuss t3 ");
        sqllsit.append(" JOIN  tab_payrecords t2 ");
        sqllsit.append(" ON t3.billid = t2.orderid ");
        sqllsit.append(" WHERE t2.paytime IS NOT NULL ");

        if (!S.isNull(begintime) && !S.isNull(endtime)) {
            sqllsit.append(" and t2.paytime >'" + begintime + "' and t2.paytime <'" + endtime + "' ");
            if (clientid > 0) {
                sqllsit.append(" and t3.enterpriseid = " + clientid);
            }
        }

        sqllsit.append(" GROUP BY t2.account ");
        //System.out.println(sqllsit);
        return sqllsit;


    }

    /**
     * 司机收入日统计
     *
     * @param begintime 电召单时间
     * @param endtime
     * @return
     */
    public static StringBuffer DriverIncomeDateStatistics(String begintime, String endtime, int clientid, String key) {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT substr(t2.paytime,1,10),t2.account,sum(t2.money),t3.msid,t3.carbox,t3.clientname ,COUNT(t2.account),t3.enterpriseid  FROM tab_phonecallbuss t3 ");
        sqllsit.append(" JOIN  tab_payrecords t2 ");
        sqllsit.append(" ON t3.billid = t2.orderid ");
        sqllsit.append(" WHERE t2.paytime IS NOT NULL ");

        if (!S.isNull(begintime) && !S.isNull(endtime)) {
            sqllsit.append(" and t2.paytime >'" + begintime + "' and t2.paytime <'" + endtime + "' ");

        }
        if (clientid > 0) {
            sqllsit.append(" and t3.enterpriseid = " + clientid);
            sqllsit.append(" GROUP BY substr(t2.paytime,1,10) ");
        } else {
            if (!S.isNull(key)) {
                sqllsit.append(" AND t2.account LIKE '" + key + "' ");
                sqllsit.append(" GROUP BY substr(t2.paytime,1,10) ");
            } else {
                sqllsit.append(" GROUP BY t2.account ");
            }

        }
        //        //System.out.println(sqllsit);
        return sqllsit;
    }

    /**
     * 司机收入月统计
     *
     * @param begintime 电召单时间
     * @param endtime
     * @return
     */
    public static StringBuffer DriverIncomeMonthStatistics(String begintime, String endtime, int clientid, String key) {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT substr(t2.paytime,1,7),t2.account,sum(t2.money),t3.msid,t3.carbox,t3.clientname ,COUNT(t2.account),t3.enterpriseid  FROM tab_phonecallbuss t3 ");
        sqllsit.append(" JOIN  tab_payrecords t2 ");
        sqllsit.append(" ON t3.billid = t2.orderid ");
        sqllsit.append(" WHERE t2.paytime IS NOT NULL ");

        if (!S.isNull(begintime) && !S.isNull(endtime)) {
            sqllsit.append(" and t2.paytime >'" + begintime + "' and t2.paytime <'" + endtime + "' ");

        }
        if (clientid > 0) {
            sqllsit.append(" and t3.enterpriseid = " + clientid);
            sqllsit.append(" GROUP BY substr(t2.paytime,1,7) ");
        } else {
            if (!S.isNull(key)) {
                sqllsit.append(" AND t2.account LIKE '" + key + "' ");
                sqllsit.append(" GROUP BY substr(t2.paytime,1,7) ");
            } else {
                sqllsit.append(" GROUP BY t2.account ");
            }

        }
        //System.out.println(sqllsit);
        return sqllsit;
    }

    /**
     * 司机收入年统计
     *
     * @param begintime 电召单时间
     * @param endtime
     * @return
     */
    public static StringBuffer DriverIncomeYearStatistics(String begintime, String endtime, int clientid, String key) {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT substr(t2.paytime,1,4),t2.account,sum(t2.money),t3.msid,t3.carbox,t3.clientname ,COUNT(t2.account),t3.enterpriseid  FROM tab_phonecallbuss t3 ");
        sqllsit.append(" JOIN  tab_payrecords t2 ");
        sqllsit.append(" ON t3.billid = t2.orderid ");
        sqllsit.append(" WHERE t2.paytime IS NOT NULL ");

        if (!S.isNull(begintime) && !S.isNull(endtime)) {
            sqllsit.append(" and substr(t2.paytime,1,4) >='" + begintime + "' and substr(t2.paytime,1,4) <='" + endtime + "' ");
        }
        if (clientid > 0) {
            sqllsit.append(" and t3.enterpriseid = " + clientid);
            sqllsit.append(" GROUP BY substr(t2.paytime,1,4) ");
        } else {
            if (!S.isNull(key)) {
                sqllsit.append(" AND t2.account LIKE '" + key + "' ");
                sqllsit.append(" GROUP BY substr(t2.paytime,1,4) ");
            } else {
                sqllsit.append(" GROUP BY t2.account ");
            }
        }

        //System.out.println(sqllsit);
        return sqllsit;
    }

    /**
     * 司机诚信记录
     *
     * @return
     */
    public static StringBuffer DriverIntegrity(int clientid, String key) {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT d.name,d.kabnum,d.phone,d.clientid,d.isstop,IFNULL(driverorder.eva,3),IFNULL(driverorder.allorder,0) ,IFNULL(driverorder.successorder,0),IFNULL(driverorder.cancelorder,0) ,IFNULL(d.toaccount,0),IFNULL(d.tomileage,0),IFNULL(d.tomoney,0),IFNULL(d.tovainmileage,0) ");
        sqllsit.append(" FROM ");
        sqllsit.append(" (SELECT  A.id,A.account,A.pwd,A.msid,A.kabnum,A.`name`,A.sex,A.phone,A.createtime,A.lastlg,A.lastlt,A.gpstime,A.isonline,A.company,A.isstop,A.driverpic,A.drivercardid,A.licenseid,A.operationid,A.serialnum,A.validitydatetime,A.clientid,A.identity,A.terminalid,A.unit,B.toaccount,B.tomileage,B.tomoney,B.tovainmileage ");
        sqllsit.append(" FROM tab_driver A ");
        sqllsit.append(" LEFT JOIN (SELECT tp.account, COUNT(tp.account) as toaccount ,SUM(tp.mileage) as tomileage,SUM(tp.money) as tomoney,SUM(tp.vainmileage) as tovainmileage FROM `tab_payrecords` tp GROUP BY account) B ");
        sqllsit.append(" ON A.account = B.account ");
        sqllsit.append(" ORDER BY A.account DESC) d ");
        sqllsit.append(" LEFT JOIN ( ");
        sqllsit.append(" SELECT o.msid AS drivername , ");
        sqllsit.append(" COUNT(o.msid ) AS allorder , ");
        sqllsit.append(" SUM(`status`=4) AS successorder, ");
        sqllsit.append(" SUM(`status`=3 ) AS cancelorder, ");
        sqllsit.append(" SUM(evaluate) AS eva ");
        sqllsit.append(" FROM tab_phonecallbuss o ");
        sqllsit.append(" GROUP BY msid ");
        sqllsit.append(" ORDER BY COUNT(msid) DESC ) driverorder ");
        sqllsit.append(" ON d.msid = driverorder.drivername ");


        if (clientid > 0) {

            if (!S.isNull(key)) {
                sqllsit.append(" WHERE d.clientid = " + clientid);
                sqllsit.append(" AND (d.`name` LIKE '%" + key + "%' or d.kabnum LIKE '%" + key + "%' or d.phone LIKE '%" + key + "%' )");
            } else {
                sqllsit.append(" WHERE d.clientid = " + clientid);
            }
        } else {
            if (!S.isNull(key)) {
                sqllsit.append(" WHERE (d.`name` LIKE '%" + key + "%' or d.kabnum LIKE '%" + key + "%' or d.phone LIKE '%" + key + "%' )");
            }

        }

        //System.out.println(sqllsit);
        return sqllsit;
    }

    public static Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String repSub(String str) {
        String str1 = str.replaceAll("-", "");
        str1 = str1.substring(2, 8) + "000000000";
        return str1;
    }

    @Override
    public Callbuss findBybillId(String id) {
        DetachedCriteria dc = DetachedCriteria.forClass(Callbuss.class);
        dc.add(Restrictions.eq("billid", id));
        return callBussDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public Callbuss findByKabnumPhone(String phone, String kabnum) {
        StringBuffer sqllsit = CallBussByPhoneKabnum(phone, kabnum);
        List<Object[]> obj = callBussDao.findListSql(String.valueOf(sqllsit));

        if (!S.isNull(obj) && obj.size() > 0) {
            Callbuss callbuss = new Callbuss();
            callbuss.setBillid(obj.get(0)[0].toString());
            callbuss.setOpruser(obj.get(0)[1].toString());
            callbuss.setCallnumber(obj.get(0)[2].toString());
            callbuss.setClientname(obj.get(0)[3].toString());
            callbuss.setClientsex(Integer.parseInt(obj.get(0)[4].toString()));
            callbuss.setClientmobile(obj.get(0)[5].toString());
            callbuss.setCarbox(obj.get(0)[6].toString());
            callbuss.setOrderType(Integer.parseInt(obj.get(0)[7].toString()));
            return callbuss;
        } else {
            return null;
        }

    }

    @Override
    public PageList findPageList(int page, int size, String sort, String order, String key, String begintime, String endtime, Integer type, Integer ordertype) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Callbuss.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(opruser like '%" + key + "%' or carbox like '%" + key + "%'or billid like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("calltime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("calltime", end));
        }
        if (type > (-1)) {
            dc.add(Restrictions.eq("status", type));
        }
        if (ordertype > (-1)) {
            dc.add(Restrictions.eq("orderType.typeid", ordertype));
        }
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }

        PageList pageList = new PageList(page, size);
        pageList = callBussDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer status, Integer ordertype, Integer type, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Callbuss.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(opruser like '%" + key + "%' or carbox like '%" + key + "%'or billid like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("calltime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("calltime", end));
        }
        if (status > (-1)) {
            dc.add(Restrictions.eq("status", status));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("type", type));
        }
        if (clientid != null) {
            if (clientid > (0)) {
                dc.add(Restrictions.eq("enterpriseid", clientid));
            }
        }

        if (ordertype > (-1)) {
            dc.add(Restrictions.eq("orderType", ordertype));
        }
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = callBussDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PageList findListByOpruser(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer status, Integer ordertype, Integer type, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Callbuss.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.eq("opruser", key));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("calltime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("calltime", end));
        }
        if (status > (-1)) {
            dc.add(Restrictions.eq("status", status));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("type", type));
        }
        if (clientid != null) {
            if (clientid > (0)) {
                dc.add(Restrictions.eq("enterpriseid", clientid));
            }
        }

        if (ordertype > (-1)) {
            dc.add(Restrictions.eq("orderType", ordertype));
        }
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = callBussDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PageList findListByDate(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer status, Integer ordertype, Integer type, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Callbuss.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction(" calltime LIKE '%" + key + "%'"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("calltime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("calltime", end));
        }
        if (status > (-1)) {
            dc.add(Restrictions.eq("status", status));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("type", type));
        }
        if (clientid != null) {
            if (clientid > (0)) {
                dc.add(Restrictions.eq("enterpriseid", clientid));
            }
        }

        if (ordertype > (-1)) {
            dc.add(Restrictions.eq("orderType", ordertype));
        }
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = callBussDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PageList findListByMsid(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer status, Integer ordertype, Integer type, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Callbuss.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.eq("driver.msid", key));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("calltime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("calltime", end));
        }
        if (status > (-1)) {
            dc.add(Restrictions.eq("status", status));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("type", type));
        }
        if (clientid != null) {
            if (clientid > (0)) {
                dc.add(Restrictions.eq("enterpriseid", clientid));
            }
        }

        if (ordertype > (-1)) {
            dc.add(Restrictions.eq("orderType", ordertype));
        }
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = callBussDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public List<Callbuss> findListByToMsid(String sort, String order, String key, String begintime, String endtime, Integer status, Integer ordertype, Integer type, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Callbuss.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.eq("driver.msid", key));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("calltime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("calltime", end));
        }
        if (status > (-1)) {
            dc.add(Restrictions.eq("status", status));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("type", type));
        }
        if (clientid != null) {
            if (clientid > (0)) {
                dc.add(Restrictions.eq("enterpriseid", clientid));
            }
        }

        if (ordertype > (-1)) {
            dc.add(Restrictions.eq("orderType", ordertype));
        }
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        return callBussDao.findByDetachedCriteria(dc);
    }

    @Override
    public PageList findCallsBymsid(int page, int size, String sort, String order, String msid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Callbuss.class);
        dc.add(Restrictions.like("driver.msid", msid));
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, size);
        pageList = callBussDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public List<Callbuss> findCallBussByTime(String begintime, String endtime, int status) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Callbuss.class);


        //        if (status!=0){
        //            if (status==1){
        //                dc.add(Restrictions.sqlRestriction("(status < 3 OR status > 4) "));
        //            }else if (status==2){
        //                dc.add(Restrictions.sqlRestriction("(status =3 "));
        //            }else if (status==3){
        //                dc.add(Restrictions.sqlRestriction("(status =4) "));
        //            }
        //
        //        }

        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("calltime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("calltime", end));
        }
        dc.addOrder(Order.desc("calltime"));

        return callBussDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<CallBussReport> findCallBuss(String begintime, String endtime) {
        StringBuffer sqllsit = CallBussRePort(begintime, endtime);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<CallBussReport> callBusslist = new ArrayList<CallBussReport>();
        CallBussReport callBean;
        for (Object[] objects : list) {
            callBean = new CallBussReport();
            callBean.setTotal(objects[0] == null ? 0 : Integer.parseInt(objects[0].toString()));
            callBean.setUnfinish(objects[1] == null ? 0 : Integer.parseInt(objects[1].toString()));
            callBean.setCancellation(objects[2] == null ? 0 : Integer.parseInt(objects[2].toString()));
            callBean.setFinish(objects[3] == null ? 0 : Integer.parseInt(objects[3].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;

    }

    @Override
    public List<Callbuss> findCallBuss(String sort, String order, String key, String begintime, String endtime, Integer type, Integer ordertype, Integer clientid, Integer status) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Callbuss.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(opruser like '%" + key + "%' or carbox like '%" + key + "%'or billid like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("calltime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("calltime", end));
        }
        if (type > (-1)) {
            dc.add(Restrictions.eq("status", type));
        }
        if (ordertype > (-1)) {
            dc.add(Restrictions.eq("orderType", ordertype));
        }

        if (clientid != null) {
            if (clientid > (0)) {
                dc.add(Restrictions.eq("enterpriseid", clientid));
            }
        }
        //        if ("desc".equals(order)) {
        //            dc.addOrder(Order.desc(sort));
        //        } else {
        //            dc.addOrder(Order.asc(sort));
        //        }
        List<Callbuss> callbusses = callBussDao.findByDetachedCriteria(dc);
        System.out.println(callbusses);
        return callbusses;
    }

    @Override
    public List<DateCallBussReport> findDateCallBuss(String begintime, String endtime, Integer clientid) {
        StringBuffer sqllsit = DateCallBussRePort(begintime, endtime, clientid);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<DateCallBussReport> callBusslist = new ArrayList<DateCallBussReport>();
        DateCallBussReport callBean;
        for (Object[] objects : list) {
            callBean = new DateCallBussReport();
            callBean.setDatatime(objects[0] == null ? "" : objects[0].toString());
            callBean.setTotal(objects[1] == null ? 0 : Integer.parseInt(objects[1].toString()));
            callBean.setUnfinish(objects[2] == null ? 0 : Integer.parseInt(objects[2].toString()));
            callBean.setCancellation(objects[3] == null ? 0 : Integer.parseInt(objects[3].toString()));
            callBean.setFinish(objects[4] == null ? 0 : Integer.parseInt(objects[4].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<DriverCallBussReport> findDriverCallBuss(String begintime, String endtime, Integer clientid) {
        StringBuffer sqllsit = DriverCallBussRePort(begintime, endtime, clientid);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<DriverCallBussReport> callBusslist = new ArrayList<DriverCallBussReport>();
        DriverCallBussReport callBean;
        for (Object[] objects : list) {
            callBean = new DriverCallBussReport();
            callBean.setDrivername(objects[0] == null ? "" : objects[0].toString());
            callBean.setAccount(objects[1] == null ? "" : objects[1].toString());
            callBean.setPhone(objects[2] == null ? "" : objects[2].toString());
            callBean.setClientid(objects[3] == null ? 0 : Integer.parseInt(objects[3].toString()));
            callBean.setTotal(objects[4] == null ? 0 : Integer.parseInt(objects[4].toString()));
            callBean.setUnfinish(objects[5] == null ? 0 : Integer.parseInt(objects[5].toString()));
            callBean.setCancellation(objects[6] == null ? 0 : Integer.parseInt(objects[6].toString()));
            callBean.setFinish(objects[7] == null ? 0 : Integer.parseInt(objects[7].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<DriverCallBussReport> findDriverCallBuss(String begintime, String endtime, Integer clientid, Integer page, Integer rows) {
        StringBuffer sqllsit = DriverCallBussRePort(begintime, endtime, clientid);
        sqllsit.append(" LIMIT  " + (page - 1) * rows + "," + rows);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<DriverCallBussReport> callBusslist = new ArrayList<DriverCallBussReport>();
        DriverCallBussReport callBean;
        for (Object[] objects : list) {
            callBean = new DriverCallBussReport();
            callBean.setDrivername(objects[0] == null ? "" : objects[0].toString());
            callBean.setAccount(objects[1] == null ? "" : objects[1].toString());
            callBean.setPhone(objects[2] == null ? "" : objects[2].toString());
            callBean.setClientid(objects[3] == null ? 0 : Integer.parseInt(objects[3].toString()));
            callBean.setTotal(objects[4] == null ? 0 : Integer.parseInt(objects[4].toString()));
            callBean.setUnfinish(objects[5] == null ? 0 : Integer.parseInt(objects[5].toString()));
            callBean.setCancellation(objects[6] == null ? 0 : Integer.parseInt(objects[6].toString()));
            callBean.setFinish(objects[7] == null ? 0 : Integer.parseInt(objects[7].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    public Integer findCount(Integer clientid) {
        if (clientid == 0)
            return callBussDao.findNumberHql("Select count(id) from Driver ");
        return callBussDao.findNumberHql("Select count(id) from Driver where clientid = " + clientid);
    }

    @Override
    public List<PassengerCallBussReport> findPassengerCallBuss(String begintime, String endtime) {
        StringBuffer sqllsit = PassCallBussRePort(begintime, endtime);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<PassengerCallBussReport> callBusslist = new ArrayList<PassengerCallBussReport>();
        PassengerCallBussReport callBean;
        for (Object[] objects : list) {
            callBean = new PassengerCallBussReport();
            callBean.setOpruser(objects[0] == null ? "" : objects[0].toString());
            callBean.setTotal(objects[1] == null ? 0 : Integer.parseInt(objects[1].toString()));
            callBean.setApptotal(objects[2] == null ? 0 : Integer.parseInt(objects[2].toString()));
            callBean.setWxtotal(objects[3] == null ? 0 : Integer.parseInt(objects[3].toString()));
            callBean.setPlonetotal(objects[4] == null ? 0 : Integer.parseInt(objects[4].toString()));
            callBean.setUnfinish(objects[5] == null ? 0 : Integer.parseInt(objects[5].toString()));
            callBean.setCancellation(objects[6] == null ? 0 : Integer.parseInt(objects[6].toString()));
            callBean.setFinish(objects[7] == null ? 0 : Integer.parseInt(objects[7].toString()));
            callBean.setAppunfinish(objects[8] == null ? 0 : Integer.parseInt(objects[8].toString()));
            callBean.setAppcancellation(objects[9] == null ? 0 : Integer.parseInt(objects[9].toString()));
            callBean.setAppfinish(objects[10] == null ? 0 : Integer.parseInt(objects[10].toString()));
            callBean.setWxunfinish(objects[11] == null ? 0 : Integer.parseInt(objects[11].toString()));
            callBean.setWxcancellation(objects[12] == null ? 0 : Integer.parseInt(objects[12].toString()));
            callBean.setWxfinish(objects[13] == null ? 0 : Integer.parseInt(objects[13].toString()));
            callBean.setPloneunfinish(objects[14] == null ? 0 : Integer.parseInt(objects[14].toString()));
            callBean.setPlonecancellation(objects[15] == null ? 0 : Integer.parseInt(objects[15].toString()));
            callBean.setPlonefinish(objects[16] == null ? 0 : Integer.parseInt(objects[16].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<SeatCallBussReport> findSeatCallBuss(String begintime, String endtime, Integer clientid) {
        StringBuffer sqllsit = SeatBussRePort(begintime, endtime, clientid);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<SeatCallBussReport> callBusslist = new ArrayList<SeatCallBussReport>();
        SeatCallBussReport callBean;
        if (list.size() > 0) {
            for (Object[] objects : list) {
                callBean = new SeatCallBussReport();
                callBean.setOpruser(objects[0] == null ? "" : objects[0].toString());
                callBean.setName(objects[1] == null ? "" : objects[1].toString());
                callBean.setTotal(objects[2] == null ? 0 : Integer.parseInt(objects[2].toString()));
                callBean.setUnfinish(objects[3] == null ? 0 : Integer.parseInt(objects[3].toString()));
                callBean.setCancellation(objects[4] == null ? 0 : Integer.parseInt(objects[4].toString()));
                callBean.setFinish(objects[5] == null ? 0 : Integer.parseInt(objects[5].toString()));
                callBusslist.add(callBean);
            }
        }

        return callBusslist;
    }

    @Override
    public List<PasserCallBussReport> findPasserCallBuss(String begintime, String endtime, Integer clientid) {
        StringBuffer sqllsit = PassengBussRePort(begintime, endtime, clientid);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<PasserCallBussReport> callBusslist = new ArrayList<PasserCallBussReport>();
        PasserCallBussReport callBean;
        if (list.size() > 0) {
            for (Object[] objects : list) {
                callBean = new PasserCallBussReport();
                callBean.setOpruser(objects[0] == null ? "" : objects[0].toString());
                callBean.setName(objects[1] == null ? "" : objects[1].toString());
                callBean.setTotal(objects[2] == null ? 0 : Integer.parseInt(objects[2].toString()));
                callBean.setUnfinish(objects[3] == null ? 0 : Integer.parseInt(objects[3].toString()));
                callBean.setCancellation(objects[4] == null ? 0 : Integer.parseInt(objects[4].toString()));
                callBean.setFinish(objects[5] == null ? 0 : Integer.parseInt(objects[5].toString()));
                callBusslist.add(callBean);
            }
        }

        return callBusslist;
    }

    @Override
    public List<EvaluateBean> findEvaluate(String begintime, String endtime) {
        StringBuffer sqllsit = CallBussEvaluate(begintime, endtime);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<EvaluateBean> callBusslist = new ArrayList<EvaluateBean>();
        EvaluateBean callBean;
        for (Object[] objects : list) {
            callBean = new EvaluateBean();
            callBean.setTotal(objects[1] == null ? 0 : Integer.parseInt(objects[1].toString()));
            callBean.setNosatisfaction(objects[2] == null ? 0 : Integer.parseInt(objects[2].toString()));
            callBean.setSatisfaction(objects[3] == null ? 0 : Integer.parseInt(objects[3].toString()));
            callBean.setGoodsatisfaction(objects[4] == null ? 0 : Integer.parseInt(objects[4].toString()));
            callBean.setNotrated(objects[5] == null ? 0 : Integer.parseInt(objects[5].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<CallBussStatBean> findCallBussStat(String begintime) {
        StringBuffer sqllsit = CallBussRePortInfo(begintime);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<CallBussStatBean> callBusslist = new ArrayList<CallBussStatBean>();
        CallBussStatBean callBean;
        for (Object[] objects : list) {
            callBean = new CallBussStatBean();

            callBean.setAllorder(objects[0] == null ? 0 : Integer.parseInt(objects[0].toString()));
            callBean.setNeworder(objects[1] == null ? 0 : Integer.parseInt(objects[1].toString()));
            callBean.setProcessingorder(objects[2] == null ? 0 : Integer.parseInt(objects[2].toString()));
            callBean.setCancelorder(objects[3] == null ? 0 : Integer.parseInt(objects[3].toString()));
            callBean.setFinishorder(objects[4] == null ? 0 : Integer.parseInt(objects[4].toString()));
            callBean.setNeatnotcar(objects[5] == null ? 0 : Integer.parseInt(objects[5].toString()));
            callBean.setOuttimeorder(objects[6] == null ? 0 : Integer.parseInt(objects[6].toString()));


            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<Callbuss> findCallBussNewStatistical(String begintime, Integer length, Integer clientid) throws Exception {
        StringBuffer sqllsit = CallBussNewStatistical(begintime, length, clientid);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<Callbuss> callBusslist = new ArrayList<Callbuss>();
        Callbuss callBean;
        for (Object[] objects : list) {
            callBean = new Callbuss();

            callBean.setBillid(objects[0] == null ? "" : objects[0].toString());
            callBean.setStatus(objects[1] == null ? 0 : Integer.parseInt(objects[1].toString()));
            callBean.setCalltime(objects[2] == null ? null : StrToDate(objects[2].toString()));
            callBean.setAddress(objects[3] == null ? "" : objects[3].toString());
            callBean.setClientmobile(objects[4] == null ? "" : objects[4].toString());
            callBean.setSrcaddr(objects[5] == null ? "" : objects[5].toString());
            callBean.setOrderType(objects[6] == null ? 0 : Integer.parseInt(objects[6].toString()));
            callBean.setTimedifference(objects[7] == null ? 0 : Integer.parseInt(objects[7].toString()));
            callBean.setRemark(objects[8] == null ? "" : objects[8].toString());
            callBean.setDriver(objects[9] == null ? null : new Driver(objects[9].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<CallbussBean> findCallBussHisStatistical(String begintime, Integer length, Integer clientid) throws Exception {
        StringBuffer sqllsit = CallBussHistoryStatistical(begintime, length, clientid);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<CallbussBean> callBusslist = new ArrayList<CallbussBean>();
        CallbussBean callBean;
        for (Object[] objects : list) {
            callBean = new CallbussBean();

            callBean.setBillid(objects[0] == null ? "" : objects[0].toString());
            callBean.setStatus(objects[1] == null ? 0 : Integer.parseInt(objects[1].toString()));
            callBean.setCalltime(objects[2] == null ? null : StrToDate(objects[2].toString()));
            callBean.setAddress(objects[3] == null ? "" : objects[3].toString());
            callBean.setClientmobile(objects[4] == null ? "" : objects[4].toString());
            callBean.setCarbox(objects[5] == null ? "" : objects[5].toString());
            callBean.setSrcaddr(objects[6] == null ? "" : objects[6].toString());
            callBean.setOrderType(objects[7] == null ? 0 : Integer.parseInt(objects[7].toString()));
            callBean.setTimedifference(objects[8] == null ? 0 : Integer.parseInt(objects[8].toString()));
            callBean.setRemark(objects[9] == null ? "" : objects[9].toString());
            callBean.setMsid(objects[10] == null ? "" : objects[10].toString());
            callBean.setPhone(objects[11] == null ? "" : objects[11].toString());
            callBean.setDrivername(objects[12] == null ? "" : objects[12].toString());

            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<CallbussBean> findCallBussProStatistical(String begintime, Integer length, Integer clientid) throws Exception {
        StringBuffer sqllsit = CallBussProStatistical(begintime, length, clientid);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<CallbussBean> callBusslist = new ArrayList<CallbussBean>();
        CallbussBean callBean;
        for (Object[] objects : list) {
            callBean = new CallbussBean();

            callBean.setBillid(objects[0] == null ? "" : objects[0].toString());
            callBean.setStatus(objects[1] == null ? 0 : Integer.parseInt(objects[1].toString()));
            callBean.setCalltime(objects[2] == null ? null : StrToDate(objects[2].toString()));
            callBean.setAddress(objects[3] == null ? "" : objects[3].toString());
            callBean.setClientmobile(objects[4] == null ? "" : objects[4].toString());
            callBean.setSrcaddr(objects[5] == null ? "" : objects[5].toString());
            callBean.setOrderType(objects[6] == null ? 0 : Integer.parseInt(objects[6].toString()));
            callBean.setTimedifference(objects[7] == null ? 0 : Integer.parseInt(objects[7].toString()));
            callBean.setRemark(objects[8] == null ? "" : objects[8].toString());
            callBean.setMsid(objects[9] == null ? "" : objects[9].toString());
            callBean.setPhone(objects[10] == null ? "" : objects[10].toString());
            callBean.setDrivername(objects[11] == null ? "" : objects[11].toString());
            callBean.setCarbox(objects[12] == null ? "" : objects[12].toString());

            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<OperatingBean> findOperating(String begintime, String endtime) throws Exception {
        StringBuffer sqllsit = OperationDateReport(begintime, endtime);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<OperatingBean> callBusslist = new ArrayList<OperatingBean>();
        OperatingBean callBean;
        for (Object[] objects : list) {
            callBean = new OperatingBean();
            callBean.setDatetime(objects[0] == null ? "" : objects[0].toString());
            callBean.setOperatnum(objects[1] == null ? 0 : Integer.parseInt(objects[1].toString()));
            callBean.setOperatmileage(objects[2] == null ? 0 : Double.parseDouble(objects[2].toString()));
            callBean.setOperatmoney(objects[3] == null ? 0 : Double.parseDouble(objects[3].toString()));
            callBean.setOperatduration(objects[4] == null ? 0 : Double.parseDouble(objects[4].toString()));
            callBean.setCarnum(objects[5] == null ? 0 : Integer.parseInt(objects[5].toString()));
            callBean.setSingleoperatduration(callBean.getOperatduration() / callBean.getCarnum());
            callBean.setSingleoperatmileage(callBean.getOperatmileage() / callBean.getCarnum());
            callBean.setSingleoperatmoney(callBean.getOperatmoney() / callBean.getCarnum());
            callBean.setSingleoperatnum((double) (callBean.getOperatnum() / callBean.getCarnum()));

            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<PayBean> findPay(String begintime, String endtime) throws Exception {
        StringBuffer sqllsit = PayMentReport(begintime, endtime);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<PayBean> callBusslist = new ArrayList<PayBean>();
        PayBean callBean;
        for (Object[] objects : list) {
            callBean = new PayBean();
            callBean.setBillid(objects[0] == null ? "" : objects[0].toString());
            callBean.setGeton(objects[1] == null ? "" : objects[1].toString());
            callBean.setGetoff(objects[2] == null ? "" : objects[2].toString());
            callBean.setName(objects[3] == null ? "" : objects[3].toString());
            callBean.setAccount(objects[4] == null ? "" : objects[4].toString());
            callBean.setKabnum(objects[5] == null ? "" : objects[5].toString());
            callBean.setDriverCardID(objects[6] == null ? "" : objects[6].toString());
            callBean.setMileage(objects[7] == null ? 0 : Double.parseDouble(objects[7].toString()));
            callBean.setMoney(objects[8] == null ? 0 : Double.parseDouble(objects[8].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<DriverCommuting> findCommuting(String begintime, String endtime) throws Exception {
        StringBuffer sqllsit = DrivergetOnOff(begintime, endtime);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<DriverCommuting> callBusslist = new ArrayList<DriverCommuting>();
        DriverCommuting callBean;
        for (Object[] objects : list) {
            callBean = new DriverCommuting();
            callBean.setAccount(objects[0] == null ? "" : objects[0].toString());
            callBean.setOnwork(objects[1] == null ? "" : objects[1].toString());
            callBean.setOffwork(objects[2] == null ? "" : objects[2].toString());
            callBean.setDuration(objects[3] == null ? "" : objects[3].toString());
            callBean.setMileage(objects[4] == null ? 0 : Double.parseDouble(objects[4].toString()));
            callBean.setMoney(objects[5] == null ? 0 : Double.parseDouble(objects[5].toString()));
            callBean.setKabnum(objects[6] == null ? "" : objects[6].toString());
            callBean.setName(objects[7] == null ? "" : objects[7].toString());
            callBean.setDriverCardID(objects[8] == null ? "" : objects[8].toString());
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<OperatDetails> findOperatsDeails(String begintime, String endtime, int clientid) throws Exception {
        StringBuffer sqllsit = DriverOperateDeatails(begintime, endtime, clientid);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<OperatDetails> callBusslist = new ArrayList<OperatDetails>();
        OperatDetails callBean;
        for (Object[] objects : list) {
            callBean = new OperatDetails();
            callBean.setAccount(objects[0] == null ? "" : objects[0].toString());
            callBean.setKabnum(objects[1] == null ? "" : objects[1].toString());
            callBean.setOrdertime(objects[2] == null ? null : DateUtil.stringToDate(objects[2].toString(), "yyyy-MM-dd HH:mm:ss"));
            callBean.setGetontime(objects[3] == null ? null : DateUtil.stringToDate(objects[3].toString(), "yyyy-MM-dd HH:mm:ss"));
            callBean.setGetofftime(objects[4] == null ? null : DateUtil.stringToDate(objects[4].toString(), "yyyy-MM-dd HH:mm:ss"));
            callBean.setEnterprise(objects[5] == null ? 0 : Integer.valueOf(objects[5].toString()));
            callBean.setPassmile(objects[6] == null ? 0 : Double.valueOf(objects[6].toString()));
            callBean.setEmptymile(objects[7] == null ? 0 : Double.valueOf(objects[7].toString()));
            callBean.setAmount(objects[8] == null ? 0 : Double.valueOf(objects[8].toString()));
            callBean.setEvaluation(objects[9] == null ? 0 : Integer.valueOf(objects[9].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;

    }

    /**
     * @param begintime
     * @param endtime
     * @param clientid
     * @return
     * @throws Exception
     */
    @Override
    public PageList findPassPayDetails(int page, int rows, String begintime, String endtime, int clientid) throws Exception {
        StringBuffer sqllsit = PassPayDetail(begintime, endtime, clientid);
        //        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        PageList pageList = new PageList(page, rows);
        pageList = callBussDao.findPageList(pageList, (String.valueOf(sqllsit)), null);
        List<Object[]> list = pageList.getList();
        List<PassPayDetails> callBusslist = new ArrayList<PassPayDetails>();
        PassPayDetails callBean;
        for (Object[] objects : list) {
            callBean = new PassPayDetails();
            callBean.setPassphone(objects[0] == null ? "" : objects[0].toString());
            callBean.setPassname(objects[1] == null ? "" : objects[1].toString());
            callBean.setTotalamount(objects[2] == null ? 0 : Double.valueOf(objects[2].toString()));
            callBean.setPayamount(objects[3] == null ? 0 : Double.valueOf(objects[3].toString()));
            callBean.setTaxicoupons(0);//打车卷
            callBean.setTip(objects[4] == null ? 0 : Double.valueOf(objects[4].toString()));
            callBean.setPayment(objects[5] == null ? 0 : Integer.valueOf(objects[5].toString()));
            callBean.setCalltime(objects[6] == null ? null : DateUtil.stringToDate(objects[6].toString(), "yyyy-MM-dd HH:mm:ss"));
            callBean.setDrivername(objects[7] == null ? "" : objects[7].toString());
            callBean.setKabnum(objects[8] == null ? "" : objects[8].toString());
            callBean.setOrdernum(objects[9] == null ? "" : objects[9].toString());
            callBean.setTradeno(objects[10] == null ? "" : objects[10].toString());
            callBusslist.add(callBean);
        }
        pageList.setList(callBusslist);
        return pageList;
    }

    /**
     * @param begintime
     * @param endtime
     * @param clientid
     * @return
     * @throws Exception
     */
    @Override
    public List<DriverIncome> findDriverIncomeList(int page, int rows, String begintime, String endtime, int clientid) throws Exception {
        StringBuffer sqllsit = DriverIncomeList(begintime, endtime, clientid);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<DriverIncome> callBusslist = new ArrayList<DriverIncome>();
        DriverIncome callBean;
        for (Object[] objects : list) {
            callBean = new DriverIncome();
            callBean.setDriverphone(objects[0] == null ? "" : objects[0].toString());
            callBean.setDrivername(objects[1] == null ? "" : objects[1].toString());
            callBean.setAmount(objects[2] == null ? 0 : Double.valueOf(objects[2].toString()));
            callBean.setBill(objects[3] == null ? 0 : Double.valueOf(objects[3].toString()));
            callBean.setDrivertip(objects[4] == null ? 0 : Double.valueOf(objects[4].toString()));//小费
            callBean.setPayment(objects[5] == null ? 0 : Integer.valueOf(objects[5].toString()));
            callBean.setIncometime(objects[6] == null ? null : DateUtil.stringToDate(objects[6].toString(), "yyyy-MM-dd HH:mm:ss"));
            callBean.setKabnum(objects[7] == null ? "" : objects[7].toString());
            callBean.setPassname(objects[8] == null ? "" : objects[8].toString());
            callBean.setPassphone(objects[9] == null ? "" : objects[9].toString());
            callBean.setOrdernum(objects[10] == null ? "" : objects[10].toString());
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public PageList findDriverIncomeListByPageList(int page, int rows, String begintime, String endtime, int clientid) throws Exception {
        StringBuffer sqllsit = DriverIncomeList(begintime, endtime, clientid);
        //        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        PageList pageList = new PageList(page, rows);
        pageList = callBussDao.findPageList(pageList, (String.valueOf(sqllsit)), null);
        List<Object[]> list = pageList.getList();
        List<DriverIncome> callBusslist = new ArrayList<DriverIncome>();
        DriverIncome callBean;
        for (Object[] objects : list) {
            callBean = new DriverIncome();
            callBean.setDriverphone(objects[0] == null ? "" : objects[0].toString());
            callBean.setDrivername(objects[1] == null ? "" : objects[1].toString());
            callBean.setAmount(objects[2] == null ? 0 : Double.valueOf(objects[2].toString()));
            callBean.setBill(objects[3] == null ? 0 : Double.valueOf(objects[3].toString()));
            callBean.setDrivertip(objects[4] == null ? 0 : Double.valueOf(objects[4].toString()));//小费
            callBean.setPayment(objects[5] == null ? 0 : Integer.valueOf(objects[5].toString()));
            callBean.setIncometime(objects[6] == null ? null : DateUtil.stringToDate(objects[6].toString(), "yyyy-MM-dd HH:mm:ss"));
            callBean.setKabnum(objects[7] == null ? "" : objects[7].toString());
            callBean.setPassname(objects[8] == null ? "" : objects[8].toString());
            callBean.setPassphone(objects[9] == null ? "" : objects[9].toString());
            callBean.setOrdernum(objects[10] == null ? "" : objects[10].toString());
            callBusslist.add(callBean);
        }

        pageList.setList(callBusslist);
        return pageList;
    }

    @Override
    public PageList findDriverIncomeDetail(int page, int rows, String begintime, String endtime, int clientid) throws Exception {
        StringBuffer sqllsit = DriverIncomeDetail(begintime, endtime, clientid);
        //        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        PageList pageList = new PageList(page, rows);
        pageList = callBussDao.findPageList(pageList, (String.valueOf(sqllsit)), null);
        List<Object[]> list = pageList.getList();

        List<DriverIncomeDetail> callBusslist = new ArrayList<DriverIncomeDetail>();
        DriverIncomeDetail callBean;
        for (Object[] objects : list) {
            callBean = new DriverIncomeDetail();
            callBean.setDate(objects[0] == null ? "" : objects[0].toString());
            callBean.setName(objects[1] == null ? "" : objects[1].toString());
            callBean.setAmount(objects[2] == null ? 0 : Double.valueOf(objects[2].toString()));
            callBean.setPhone(objects[3] == null ? "" : objects[3].toString());
            callBean.setKabnum(objects[4] == null ? "" : objects[4].toString());
            callBean.setSuccessnum(objects[6] == null ? 0 : Integer.valueOf(objects[6].toString()));
            callBusslist.add(callBean);
        }
        pageList.setList(callBusslist);
        return pageList;
    }

    //   -- 年\司机名称\收入金额\明细
    @Override
    public List<DriverIncomeStatis> findDriverIncomeStatis(String begintime, String endtime, int clientid, String key) throws Exception {
        StringBuffer sqllsit = DriverIncomeYearStatistics(begintime, endtime, clientid, key);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<DriverIncomeStatis> callBusslist = new ArrayList<DriverIncomeStatis>();
        DriverIncomeStatis callBean;
        for (Object[] objects : list) {
            callBean = new DriverIncomeStatis();
            callBean.setAnnual(objects[0] == null ? "" : objects[0].toString());
            callBean.setCompany(objects[1] == null ? "" : objects[1].toString());
            callBean.setAmount(objects[2] == null ? 0 : Double.valueOf(objects[2].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<DriverIncomeStatisMonth> findDriverIncomeStatisMonth(String begintime, String endtime, int clientid, String key) throws Exception {
        StringBuffer sqllsit = DriverIncomeMonthStatistics(begintime, endtime, clientid, key);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<DriverIncomeStatisMonth> callBusslist = new ArrayList<DriverIncomeStatisMonth>();
        DriverIncomeStatisMonth callBean;
        for (Object[] objects : list) {
            callBean = new DriverIncomeStatisMonth();
            callBean.setMonth(objects[0] == null ? "" : objects[0].toString());
            callBean.setCompany(objects[1] == null ? "" : objects[1].toString());
            callBean.setAmount(objects[2] == null ? 0 : Double.valueOf(objects[2].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<DriverIncomeStatisDay> findDriverIncomeStatisDay(String begintime, String endtime, int clientid, String key) throws Exception {
        StringBuffer sqllsit = DriverIncomeDateStatistics(begintime, endtime, clientid, key);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<DriverIncomeStatisDay> callBusslist = new ArrayList<DriverIncomeStatisDay>();
        DriverIncomeStatisDay callBean;
        for (Object[] objects : list) {
            callBean = new DriverIncomeStatisDay();
            callBean.setDate(objects[0] == null ? "" : objects[0].toString());
            callBean.setCompany(objects[1] == null ? "" : objects[1].toString());
            callBean.setAmount(objects[2] == null ? 0 : Double.valueOf(objects[2].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<DriverIntegrity> findDriverIntegrity(int clientid, String key) throws Exception {
        StringBuffer sqllsit = DriverIntegrity(clientid, key);
        List<Object[]> list = callBussDao.findListSql(String.valueOf(sqllsit));
        List<DriverIntegrity> callBusslist = new ArrayList<DriverIntegrity>();
        DriverIntegrity callBean;
        for (Object[] objects : list) {
            callBean = new DriverIntegrity();
            callBean.setName(objects[0] == null ? "" : objects[0].toString());
            callBean.setKabnum(objects[1] == null ? "" : objects[1].toString());
            callBean.setPhone(objects[2] == null ? "" : objects[2].toString());
            callBean.setClientid(objects[3] == null ? 0 : Integer.valueOf(objects[3].toString()));
            callBean.setIsblacklist(objects[4] == null ? 0 : Integer.valueOf(objects[4].toString()));
            callBean.setRating(objects[5] == null ? 0 : Integer.valueOf(objects[5].toString()));
            //            callBean.set();
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

}
