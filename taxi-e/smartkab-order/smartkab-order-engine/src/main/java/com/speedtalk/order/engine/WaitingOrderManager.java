package com.speedtalk.order.engine;

import com.speedtalk.order.engine.dao.BaseDao;
import com.speedtalk.order.engine.db.TabClientSetting;
import com.speedtalk.order.engine.db.TabLogSmsdiary;
import com.speedtalk.order.engine.db.TabOrderTrack;
import com.speedtalk.order.engine.db.TabPhonecallbuss;
import com.speedtalk.protocol.order.OrderConstants;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;

import java.sql.Timestamp;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class WaitingOrderManager implements Runnable {
    private static final WaitingOrderManager instance = new WaitingOrderManager();
    private final BaseDao baseDao = new BaseDao();

    private WaitingOrderManager() {
    }

    public static WaitingOrderManager getInstance() {
        return instance;
    }

    @Override
    public void run() {
        OrderLogger.log("WaitingOrder is running...");
        long sleep = 10, waitTime = 180000, sentInterval = 20000;
        ConcurrentHashMap<String, Orders.WaitOrder> map = null;
        while (true) {
            try {
                sleep = Long.parseLong(LoadXmlConfig.getConfigHash().
                        get("waitorder-manager-sleep"));
                waitTime = Long.parseLong(LoadXmlConfig.getConfigHash().
                        get("waitorder-wait-time")) * 60000;
                sentInterval = Long.parseLong(LoadXmlConfig.getConfigHash().
                        get("waitorder-sent-interval")) * 1000;

            } catch (Exception e) {
                e.printStackTrace();
            }


            map = Orders.getInstance().getWaitOrderMap();
            long currentTime = System.currentTimeMillis();
            for (Orders.WaitOrder waitOrder : map.values()) {
                try {
                    if (currentTime - waitOrder.getFirstWaitTime() >= waitTime) {
                        Orders.getInstance().removeWaitOrder(waitOrder);
                        updateOrderStatus(waitOrder);
                        writeOrderTrack(waitOrder);
                        OrderLogger.getLogger()
                                .debug(waitOrder.getTbOrder().getBillid() + " can't find driver to send!");

                        sendExpiredSms(waitOrder);
                    } else if (currentTime - waitOrder.getFindDriverTime() >= sentInterval) {
                        Orders.getInstance().putWaitingOrder(waitOrder.getTbOrder());
                        OrderLogger.getLogger().debug(waitOrder.getTbOrder().getBillid() + " will try send again!");
                    } else {
                        OrderLogger.getLogger()
                                .debug(waitOrder.getTbOrder()
                                        .getBillid() + " wait " + (currentTime - waitOrder.getFirstWaitTime()) / 1000 + " seconds,find driver before " + (currentTime - waitOrder
                                        .getFindDriverTime()) / 1000 + " seconds!");
                    }
                } catch (Exception e) {
                    ExcepPrinter.print(e);
                }
            }

            try {
                TimeUnit.SECONDS.sleep(sleep);
            } catch (Exception e) {
            }
        }
    }

    private void updateOrderStatus(Orders.WaitOrder waitOrder) {
        TabPhonecallbuss order = (TabPhonecallbuss) baseDao.get(TabPhonecallbuss.class, waitOrder.getTbOrder()
                .getBillid());
        try {
            order.setStatus(OrderConstants.NO_DRIVER);
            baseDao.update(order);
        } catch (Exception e) {
        }
    }

    private void writeOrderTrack(Orders.WaitOrder waitOrder) {
        TabOrderTrack orderTrack = new TabOrderTrack("sys", waitOrder.getTbOrder()
                .getBillid(), OrderConstants.ORDER_TRACK_NO_DRIVER, new Timestamp(System.currentTimeMillis()), "附近无空闲司机");
        baseDao.save(orderTrack);
    }

    private void sendExpiredSms(Orders.WaitOrder waitOrder) {
        if (waitOrder.getTbOrder().getOrdertype() == OrderConstants.PHONE_ORDER || waitOrder.getTbOrder()
                .getOrdertype() == OrderConstants.VOICE_ORDER) {

            String isSms = LoadXmlConfig.getConfigHash().get("is-sms");
            if (isSms != null && isSms.equals("1"))    //发送短信通知
            {
                TabClientSetting clientSet = (TabClientSetting) baseDao.get(TabClientSetting.class, waitOrder.getTbOrder()
                        .getEnterpriseid());
                if (clientSet != null && clientSet.getMessagenum() > 0 && clientSet.getSmscancelid() != null && !clientSet
                        .getSmscancelid()
                        .trim()
                        .equals("") && clientSet.getSmskey() != null && !clientSet.getSmskey().trim().equals("")) {
                    try {
                        String waitTime = LoadXmlConfig.getConfigHash().
                                get("waitorder-wait-time");
                        SmsSender.sendSmsToPassenger(clientSet.getSmscancelid(), clientSet.getSmskey(), waitOrder.getTbOrder()
                                .getBillid(), waitOrder.getTbOrder().getCallnumber(), waitTime);
                        clientSet.setMessagenum(clientSet.getMessagenum() - 1);
                        baseDao.update(clientSet);
                        String smsTpl = LoadXmlConfig.getConfigHash().get("sms-tpl-expired");
                        if (smsTpl != null && !smsTpl.trim().equals("")) {
                            OrderLogger.getLogger().debug("Expired SMS tpl:" + smsTpl);
                            smsTpl = smsTpl.replace("#minute#", waitTime);
                            TabLogSmsdiary sms = new TabLogSmsdiary("【engine】-" + smsTpl, waitOrder.getTbOrder()
                                    .getCallnumber(), new Timestamp(System.currentTimeMillis()), waitOrder.getTbOrder()
                                    .getEnterpriseid());
                            baseDao.save(sms);
                        }
                    } catch (Exception e) {
                        OrderLogger.getLogger().debug(waitOrder.getTbOrder().getBillid() + "编码短信内容异常！");
                    }
                }
            } else
                OrderLogger.getLogger().debug(waitOrder.getTbOrder().getEnterpriseid() + " 公司没有短信可以发送!!!");
        }
    }
}
