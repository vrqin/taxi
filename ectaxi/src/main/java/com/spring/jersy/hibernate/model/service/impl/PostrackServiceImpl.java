package com.spring.jersy.hibernate.model.service.impl;


import com.spring.jersy.hibernate.model.dao.PostrackDao;
import com.spring.jersy.hibernate.model.entity.Postrack;
import com.spring.jersy.hibernate.model.service.PostrackService;
import com.spring.jersy.hibernate.publics.bean.PostrackBean;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/11.
 */
@Service
public class PostrackServiceImpl implements PostrackService {

    @Autowired
    private PostrackDao postrackDao;

    public static StringBuffer DriverTrackList(String begintime, String endtime, String kabnum, String name, String phone) {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT oper,d.kabnum,d.`name`,d.phone,d.company,pt.lg,pt.lt,pt.gpstime FROM `tab_pos_of_order_track` pt LEFT JOIN tab_driver d ON pt.oper=d.account WHERE pt.opertype=1  ");
        if (!S.isNull(begintime) && S.isNull(endtime)) {
            sqllsit.append(" AND pt.time> '" + begintime + "'");
        }
        if (S.isNull(begintime) && !S.isNull(endtime)) {
            sqllsit.append(" AND pt.time< '" + endtime + "'");
        }
        if (!S.isNull(begintime) && !S.isNull(endtime)) {
            sqllsit.append(" AND pt.time> '" + begintime + "'   AND pt.time< '" + endtime + "'");
        }
        if (!S.isNull(kabnum)) {
            sqllsit.append(" AND d.kabnum = '" + kabnum + "' ");
        }
        if (!S.isNull(phone)) {
            sqllsit.append(" AND d.phone = '" + phone + "' ");
        }
        if (!S.isNull(name)) {
            sqllsit.append(" AND d.name = '" + name + "' ");
        }


        return sqllsit;

    }

    public static StringBuffer DriverTrackscal(String begintime, String endtime, String kabnum, String name, String phone, int clientid) {
        StringBuffer sqllsit = new StringBuffer();
        if (clientid == 0) {
            sqllsit.append(" SELECT oper,COUNT(oper),d.kabnum,d.`name`,d.phone,d.company,d.clientid FROM `tab_pos_of_order_track` pt LEFT JOIN tab_driver d ON pt.oper=d.account WHERE pt.opertype=1   ");
        } else {
            sqllsit.append(" SELECT oper,COUNT(oper),d.kabnum,d.`name`,d.phone,d.company,d.clientid FROM `tab_pos_of_order_track` pt LEFT JOIN tab_driver d ON pt.oper=d.account WHERE pt.opertype=1 AND clientid = " + clientid);
        }

        if (!S.isNull(begintime) && S.isNull(endtime)) {
            sqllsit.append(" AND pt.time> '" + begintime + "'");
        }
        if (S.isNull(begintime) && !S.isNull(endtime)) {
            sqllsit.append(" AND pt.time< '" + endtime + "'");
        }
        if (!S.isNull(begintime) && !S.isNull(endtime)) {
            sqllsit.append(" AND pt.time> '" + begintime + "'   AND pt.time< '" + endtime + "'");
        }
        if (!S.isNull(kabnum)) {
            sqllsit.append(" AND d.kabnum LIKE '%" + kabnum + "%' ");
        }
        if (!S.isNull(phone)) {
            sqllsit.append(" AND d.phone LIKE '%" + phone + "%' ");
        }
        if (!S.isNull(name)) {
            sqllsit.append(" AND d.name LIKE '%" + name + "%' ");
        }

        sqllsit.append(" GROUP BY pt.oper  ");
        return sqllsit;

    }

    @Override
    public List<Postrack> findAllList(String orderid, int opertype) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Postrack.class);
        dc.add(Restrictions.eq("orderid", orderid));
        dc.add(Restrictions.eq("opertype", opertype));

        dc.addOrder(Order.asc("gpstime"));
        return postrackDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<Postrack> findListByKabnum(String startime, String endtime, String oper) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Postrack.class);

        if (!S.isNull(oper)) {
            dc.add(Restrictions.eq("oper", oper));
        }

        if (!S.isNull(startime)) {
            Date start = DateUtil.stringToDate(startime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("gpstime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("gpstime", end));
        }


        return postrackDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<Postrack> findDriversByTime(String startime, String endtime) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Postrack.class);

        dc.add(Restrictions.eq("opertype", 1));

        if (!S.isNull(startime)) {
            Date start = DateUtil.stringToDate(startime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("gpstime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("gpstime", end));
        }
        dc.addOrder(Order.asc("gpstime"));

        return postrackDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<PostrackBean> findDriverTrackByTime(String begintime, String endtime, String kabnum, String name, String phone, int clientid) throws Exception {
        StringBuffer sqllsit = DriverTrackscal(begintime, endtime, kabnum, name, phone, clientid);
        List<Object[]> list = postrackDao.findListSql(String.valueOf(sqllsit));
        List<PostrackBean> callBusslist = new ArrayList<PostrackBean>();
        PostrackBean ptbean;
        for (Object[] objects : list) {
            ptbean = new PostrackBean();
            ptbean.setOper(objects[0] == null ? "" : objects[0].toString());
            ptbean.setTrackcount(objects[1] == null ? 0 : Integer.parseInt(objects[1].toString()));
            ptbean.setKabnum(objects[2] == null ? "" : objects[2].toString());
            ptbean.setName(objects[3] == null ? "" : objects[3].toString());
            ptbean.setPhone(objects[4] == null ? "" : objects[4].toString());
            ptbean.setCompany(objects[5] == null ? "" : objects[5].toString());

            callBusslist.add(ptbean);
        }
        return callBusslist;
    }

    @Override
    public List<PostrackBean> findPosTrack(String begintime, String endtime, String kabnum, String name, String phone) throws Exception {
        StringBuffer sqllsit = DriverTrackList(begintime, endtime, kabnum, name, phone);
        List<Object[]> list = postrackDao.findListSql(String.valueOf(sqllsit));
        List<PostrackBean> callBusslist = new ArrayList<PostrackBean>();
        PostrackBean ptbean;
        for (Object[] objects : list) {
            ptbean = new PostrackBean();
            ptbean.setOper(objects[0] == null ? "" : objects[0].toString());
            ptbean.setKabnum(objects[1] == null ? "" : objects[1].toString());
            ptbean.setName(objects[2] == null ? "" : objects[2].toString());
            ptbean.setPhone(objects[3] == null ? "" : objects[3].toString());
            ptbean.setCompany(objects[4] == null ? "" : objects[4].toString());
            ptbean.setLg(objects[5] == null ? 0 : Double.parseDouble(objects[5].toString()));
            ptbean.setLt(objects[6] == null ? 0 : Double.parseDouble(objects[6].toString()));
            ptbean.setGpstime(objects[7] == null ? "" : objects[7].toString());
            callBusslist.add(ptbean);
        }
        return callBusslist;
    }


}
