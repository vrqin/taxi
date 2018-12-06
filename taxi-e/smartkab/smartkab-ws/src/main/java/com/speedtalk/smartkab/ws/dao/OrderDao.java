package com.speedtalk.smartkab.ws.dao;

import com.speedtalk.smartkab.ws.Constants;
import com.speedtalk.smartkab.ws.Utils;
import com.speedtalk.smartkab.ws.db.*;
import com.speedtalk.smartkab.ws.domain.Driver;
import com.speedtalk.smartkab.ws.domain.HisOrderInfo;
import com.speedtalk.smartkab.ws.domain.Order;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public UserDao userDao;
    public BaseDao baseDao;

    public OrderDao() {
        userDao = new UserDao();
        baseDao = new BaseDao();
    }

    public TabPhonecallbuss getOrder(String orderId) {
        TabPhonecallbuss order = null;
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            order = (TabPhonecallbuss) session.get(TabPhonecallbuss.class, orderId);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    /**
     * save order
     *
     * @param order
     * @return order serial number
     * @throws NullPointerException     order object is null
     * @throws IllegalArgumentException account of order error
     */
    public TabPhonecallbuss save(Order order) throws NullPointerException, IllegalArgumentException {
        if (null == order)
            throw new NullPointerException("Order is null!");
        /**
         * 兼容座席录单
         */
        TabPhoneuser tbUser = userDao.getByAccount(order.getPhone());
        if (null == tbUser)
            tbUser = userDao.getByAccount(order.getAccount());

        TabSeats seats = null;
        try {
            DetachedCriteria dc = DetachedCriteria.forClass(TabSeats.class);
            dc.add(Restrictions.eq("account", order.getAccount()));
            seats = (TabSeats) baseDao.findObjByDetachedCriteria(dc);
        } catch (Exception e) {
        }

        TabPhonecallbuss tbOrder = new TabPhonecallbuss();

        String serialNum = Utils.getOrderSerialNum();
        tbOrder.setBillid(serialNum);
        tbOrder.setIslock(0);
        tbOrder.setStatus(Constants.NEW_ORDER);
        tbOrder.setOpruser(order.getAccount());
        tbOrder.setCalltime(new Timestamp(System.currentTimeMillis()));
        if (order.getName() != null && !order.getName().trim().equals("")) {
            tbOrder.setClientname(order.getName());
        } else {
            tbOrder.setClientname(null == tbUser ? "" : tbUser.getName());
        }

        tbOrder.setClientsex(null == tbUser ? 0 : tbUser.getSex());
        tbOrder.setAddress(order.getDstAddr());
        if (null == order.getPhone()) {
            tbOrder.setClientmobile(null == tbUser ? "" : tbUser.getMobile());
            tbOrder.setCallnumber(null == tbUser ? "" : tbUser.getMobile());
        } else {
            tbOrder.setClientmobile(order.getPhone());
            tbOrder.setCallnumber(order.getPhone());
        }
        tbOrder.setLg(order.getDstLg());
        tbOrder.setLt(order.getDstLt());
        tbOrder.setSrcaddr(order.getSrcAddr());
        tbOrder.setSrclg(order.getSrcLg());
        tbOrder.setSrclt(order.getSrcLt());
        tbOrder.setType(order.getType());
        tbOrder.setRemark(order.getRemark());
        tbOrder.setOrdertype(order.getOrderType());

        if (seats != null)
            tbOrder.setEnterpriseid(seats.getClientid());
        /**
         * 指定司机接单
         */
        if (order.getDriver() != null && !order.getDriver().trim().equals("")) {
            DetachedCriteria dc = DetachedCriteria.forClass(TabDriver.class);
            dc.add(Restrictions.eq("account", order.getDriver()));
            TabDriver tbDriver = (TabDriver) baseDao.findObjByDetachedCriteria(dc);
            try {
                tbOrder.setMsid(tbDriver.getMsid());
                tbOrder.setCarbox(tbOrder.getCarbox());
            } catch (Exception e) {
            }
        }

        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            session.save(tbOrder);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tbOrder;
    }

    public void update(TabPhonecallbuss order) {
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            session.update(order);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropOrder(String orderId, Integer status, String remark) {
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            Query q = session.createSQLQuery("update tab_phonecallbuss " + "set status=:status,remark=:remark where " + "billid=:orderId");
            q.setInteger("status", status);
            q.setString("remark", remark);
            q.setString("orderId", orderId);
            q.executeUpdate();
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * query driver info of order
     *
     * @param account
     * @param orderNum
     * @return driver info
     */
    public Driver getDriver(String account, String orderNum) {
        Driver driver = new Driver();
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            List<TabDriver> tbDrivers = (List<TabDriver>) session.createSQLQuery("SELECT " + "d.* FROM tab_phonecallbuss o,tab_driver d " + "where o.msid = d.msid and o.opruser =:account " + "and o.billid =:ordernum ")
                    .addEntity(TabDriver.class)
                    .setString("account", account)
                    .setString("ordernum", orderNum)
                    .list();
            tx.commit();
            session.close();
            driver.setOrderNum(orderNum);
            if (tbDrivers != null && !tbDrivers.isEmpty()) {
                TabDriver tbDriver = tbDrivers.get(0);
                driver.setMsId(tbDriver.getMsid());
                driver.setKabNum(tbDriver.getKabnum());
                driver.setDriverName(tbDriver.getName());
                driver.setDriverPhone(tbDriver.getPhone());
                driver.setDriverSex(tbDriver.getSex().toString());
                driver.setCompany(tbDriver.getCompany());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    public void acceptOrder(String orderNum, String msId, String kabNum) {
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            TabPhonecallbuss order = (TabPhonecallbuss) session.get(TabPhonecallbuss.class, orderNum);
            order.setMsid(msId);
            order.setCarbox(kabNum);
            order.setAnswerde(new Timestamp(System.currentTimeMillis()));
            order.setStatus(Constants.FINISHED_ORDER);
            session.update(order);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<HisOrderInfo> getHisOrder(String account, String orderNum, int count, byte who) {
        List<HisOrderInfo> list = new ArrayList<HisOrderInfo>();
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            String tempAccount = account.replaceAll("(?i)delete|(?i)select|(?i)update", "");
            String sql = "select o.billid,o.opruser,o.srcaddr,o.srclg,o.srclt,o.address,o.lg," + "o.lt,o.calltime,(select name from tab_driver where msid=o.msid) " + "as NAME,o.carbox,(select phone from tab_driver where msid=o.msid) " + "as phone,(select DISTINCT(company) from tab_driver where msid=o.msid)  " + "as company,o.evaluate,o.status,o.remark,o.ordertype from tab_phonecallbuss o ";
            if (Constants.PASSENGER == who)
                sql += " where o.opruser='" + tempAccount + "'";
            else
                sql += ",tab_driver d where o.msid=d.msid and d.account='" + tempAccount + "'";
            if (orderNum != null && !orderNum.trim().equals("") && orderNum.length() == 15) {
                String tempOrderNum = orderNum.replaceAll("(?i)delete|(?i)select|(?i)update", "");
                sql += " and  billid<'" + tempOrderNum + "'";
            }
            sql += " ORDER BY o.calltime desc LIMIT " + count;
            Query q = session.createSQLQuery(sql);
            //			q.setString("account",account);
            //			if(orderNum != null && !orderNum.trim().equals("") && orderNum.length() == 15)
            //				q.setString("orderNum",orderNum);
            List<Object[]> tempList = q.list();
            HisOrderInfo order;
            Object to;
            for (Object[] o : tempList) {
                int i = 0;
                try {
                    order = new HisOrderInfo();
                    order.setOrderNum(o[i++].toString());
                    order.setPasser(o[i++].toString());
                    to = o[i++];
                    order.setSrcAddr(null == to ? null : to.toString());
                    to = o[i++];
                    order.setSrcLg(null == to ? null : to.toString());
                    to = o[i++];
                    order.setSrcLt(null == to ? null : to.toString());
                    to = o[i++];
                    order.setDstAddr(null == to ? null : to.toString());
                    to = o[i++];
                    order.setDstLg(null == to ? null : to.toString());
                    to = o[i++];
                    order.setDstLt(null == to ? null : to.toString());
                    to = o[i++];
                    order.setTime(null == to ? null : to.toString());
                    to = o[i++];
                    order.setdName(null == to ? null : to.toString());
                    to = o[i++];
                    order.setKabNum(null == to ? null : to.toString());
                    to = o[i++];
                    order.setdPhone(null == to ? null : to.toString());
                    to = o[i++];
                    order.setCompany(null == to ? null : to.toString());
                    to = o[i++];
                    order.setEvaluate(null == to ? null : to.toString());
                    to = o[i++];
                    order.setStatus(null == to ? null : to.toString());
                    to = o[i++];
                    order.setRemark(null == to ? null : to.toString());
                    to = o[i++];
                    order.setOrdertype(null == to ? null : to.toString());

                    list.add(order);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                session.close();
            } catch (Exception e2) {
            }
            try {
                tx.rollback();
            } catch (Exception e2) {
            }
        }

        return list;
    }
}
