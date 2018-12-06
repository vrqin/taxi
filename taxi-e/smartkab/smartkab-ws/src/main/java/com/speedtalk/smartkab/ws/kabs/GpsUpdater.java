package com.speedtalk.smartkab.ws.kabs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.mq.MQReceiver;
import com.speedtalk.protocol.tscobjs.GPS;
import com.speedtalk.smartkab.ws.KabInfoLoader;
import com.speedtalk.smartkab.ws.Utils;
import com.speedtalk.smartkab.ws.dao.DriverDao;
import com.speedtalk.smartkab.ws.db.TabDriver;

import javax.jms.JMSException;

public class GpsUpdater implements Runnable {
    private String mqAddr;
    private String queueName;
    private MQReceiver receiver;
    private boolean isRun;

    public GpsUpdater(String mqAddr, String queueName) {
        this.mqAddr = mqAddr;
        this.queueName = queueName;
        this.isRun = true;
        try {
            this.initMqReceiver();
        } catch (JMSException jme) {
            jme.printStackTrace();
            System.out.println(Utils.getLogFix() + "init GpsMq Receiver occur exception!!!");
        }
    }

    public void setRun(boolean isRun) {
        this.isRun = isRun;
    }

    private void initMqReceiver() throws JMSException {
        receiver = new MQReceiver(mqAddr, queueName);
    }

    @Override
    public void run() {
        System.out.println(Utils.getLogFix() + "GpsMq接收线程启动...");
        KabInfoLoader.loadKabInfos();
        DriverDao driverDao = new DriverDao();
        TabDriver driver;
        TSCObject mess;
        GPS gps;
        KabInfo kabInfo;
        while (isRun) {
            if (null == receiver) {
                try {
                    this.initMqReceiver();
                } catch (JMSException jme) {
                    System.out.println(Utils.getLogFix() + "***********init GpsMq Receiver occur exception!!!");
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    continue;
                }
            }
            for (int i = 0; i < 100; i++) {
                try {
                    mess = receiver.revMessage();
                } catch (JMSException jmse) {
                    jmse.printStackTrace();
                    receiver = null;
                    break;
                    // continue;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                    // continue;
                }
                try {
                    if (null == mess) {
                        break;
                        // continue;
                    } else if (mess instanceof GPS) {
                        gps = (GPS) mess;
                        kabInfo = KabTeam.getInstance().getKab(gps.getSrcMsID());
                        try {
                            kabInfo.setLg(gps.getLg());
                            kabInfo.setLt(gps.getLt());
                            kabInfo.setDirection(gps.getDirection());
                            kabInfo.setTime(System.currentTimeMillis());
                            kabInfo.setOnline(KabTeam.ONLINE);
                            KabTeam.getInstance().updateKab(kabInfo);
                            System.out.println(Utils.getLogFix() + "KabInfo:" + kabInfo.toString());
                        } catch (NullPointerException npe) {
                            driver = driverDao.getDriverByAccount(gps.getSrcMsID());
                            try {
                                kabInfo = new KabInfo();
                                kabInfo.setAccount(gps.getSrcMsID());
                                kabInfo.setMsId(driver.getMsid());
                                kabInfo.setName(driver.getKabnum());
                                kabInfo.setCarry(KabTeam.UNCARRY);
                                kabInfo.setOnline(KabTeam.ONLINE);
                                kabInfo.setLg(gps.getLg());
                                kabInfo.setLt(gps.getLt());
                                kabInfo.setTime(System.currentTimeMillis());
                                kabInfo.setIsApp(KabTeam.APP);

                                KabTeam.getInstance().updateKab(kabInfo);

                                System.out.println(Utils.getLogFix() + " add new kab info " + gps.getSrcMsID());
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println(Utils.getLogFix() + " get kab info occurred exception" + gps.getSrcMsID());
                            }
                        }
                    } else {
                        System.out.println(Utils.getLogFix() + "Receive other mess:" + mess.toString());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Utils.getLogFix() + "GpsMq接收线程退出!");
    }
}
