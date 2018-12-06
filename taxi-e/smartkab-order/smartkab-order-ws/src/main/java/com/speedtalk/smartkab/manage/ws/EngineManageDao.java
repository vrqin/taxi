package com.speedtalk.smartkab.manage.ws;

import com.speedtalk.smartkab.manage.ws.db.HibernateSessionFactory;
import com.speedtalk.smartkab.manage.ws.db.TbEngineManage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EngineManageDao {
    public TbEngineManage getByIp(String ip) throws NullPointerException {
        if (null == ip || ip.trim().equals(""))
            throw new NullPointerException("ip is null");
        Session session;
        Transaction tx;
        TbEngineManage engineManage = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            Query q = session.createQuery(" from TbEngineManage where ip=:ip");
            q.setString("ip", ip);
            engineManage = (TbEngineManage) q.uniqueResult();
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return engineManage;
    }
}
