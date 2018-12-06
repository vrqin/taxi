package com.speedtalk.order.engine.threads;

import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.dao.BaseDao;
import com.speedtalk.order.engine.db.TabNotifierHistory;
import com.speedtalk.order.engine.db.TabNotifierPlus;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.protocol.order.objs.OrderSms;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NoticeSender implements Runnable {
    private static final int UNSEND = 0;
    private static final int SENT = 1;
    private static final int EXPIRED = 2;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private BaseDao baseDao = new BaseDao();

    @Override
    public void run() {
        OrderLogger.getLogger().debug("NoticeSender is running...");
        int sleep = 5;
        List<Object> list = null;
        //		TabNotifierPlus plus = null;
        TabNotifierHistory his = null;
        Calendar cal = null;
        boolean isExpired = false;
        OrderSms sms = null;
        KabInfo kab = null;
        Timestamp sendTime = null;
        StringBuilder buf = new StringBuilder("发送通知给:");
        int bufLen = buf.length();
        while (true) {
            try {
                sleep = Integer.parseInt(LoadXmlConfig.getConfigHash().get("notice-sender-sleep"));
            } catch (Exception e) {
            }
            try {
                TimeUnit.MINUTES.sleep(sleep);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            list = getValidNotice();
            cal = Calendar.getInstance();
            sendTime = new Timestamp(System.currentTimeMillis());
            try {
                buf.setLength(bufLen);
                for (Object o : list) {
                    try {
                        his = (TabNotifierHistory) o;
                        isExpired = isExpired(cal, his.getNotice());
                        try {
                            if (isExpired) {
                                his.setStatus(EXPIRED);
                                baseDao.update(his);
                            } else {
                                kab = KabTeam.getInstance().getKabById(his.getDriverid());
                                try {
                                    sms = new OrderSms(kab.getAccount(), kab.getName(), his.getNotice().getContent());
                                    try {
                                        kab.getSession().write(sms);
                                        buf.append(kab.getAccount()).append(",");
                                        his.setStatus(SENT);
                                        his.setSendtime(sendTime);
                                        baseDao.update(his);
                                    } catch (Exception e) {
                                    }
                                } catch (NullPointerException npe) {
                                } catch (Exception e) {
                                    ExcepPrinter.print(e);
                                }
                            }
                        } catch (Exception e) {
                            ExcepPrinter.print(e);
                        }
                    } catch (Exception e) {
                        ExcepPrinter.print(e);
                    }
                }
                if (buf.length() > bufLen)
                    OrderLogger.getLogger().debug(buf.toString());
            } catch (NullPointerException npe) {
            } catch (Exception e) {
                ExcepPrinter.print(e);
            }
        }
    }

    /**
     * 获取未发送的通知
     *
     * @return
     */
    private List<Object> getValidNotice() {
        //		DetachedCriteria dc = DetachedCriteria.forClass(TabNotifierPlus.class);
        //		dc.createAlias("his","h").add(Restrictions.eq("h.status",UNSEND));
        //		return baseDao.findByDetachedCriteria(dc);
        DetachedCriteria dc = DetachedCriteria.forClass(TabNotifierHistory.class);
        dc.add(Restrictions.eq("status", UNSEND));
        return baseDao.findByDetachedCriteria(dc);
    }

    /**
     * 检测通知是否过期
     *
     * @param cal 当前时间
     * @param n   通知过期时间
     * @return 超时返回true，否则返还false
     */
    private boolean isExpired(Calendar cal, TabNotifierPlus n) {
        //		return cal.getTime().after(n.getExpired());
        return sdf.format(cal.getTime()).compareTo(sdf.format(n.getExpired())) > 0;
    }
}
