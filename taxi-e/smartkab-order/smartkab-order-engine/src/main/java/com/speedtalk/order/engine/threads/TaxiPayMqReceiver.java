package com.speedtalk.order.engine.threads;

import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.protocol.order.mq.MQReceiver;
import com.speedtalk.protocol.order.objs.OrderMess;
import com.speedtalk.protocol.order.objs.PayResult;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;

import javax.jms.JMSException;

public class TaxiPayMqReceiver implements Runnable {
    private String mqAddr;
    private String queueName;
    private MQReceiver receiver;

    public TaxiPayMqReceiver(String mqAddr, String queueName) {
        this.mqAddr = mqAddr;
        this.queueName = queueName;
        try {
            initMqReceiver();
        } catch (JMSException jme) {
            ExcepPrinter.print(jme);
            OrderLogger.getLogger().debug("init TaxiPayMqReceiver occur exception!!!");
        }
    }

    private void initMqReceiver() throws JMSException {
        receiver = new MQReceiver(mqAddr, queueName);
    }

    @Override
    public void run() {
        OrderLogger.log("TaxiPayMqReceiver is running...");
        OrderMess mess = null;
        while (true) {
            try {
                Thread.sleep(updateSleep());
            } catch (Exception e) {
            }

            if (null == receiver) {
                try {
                    initMqReceiver();
                } catch (JMSException jme) {
                    OrderLogger.getLogger().debug("***********init TaxiPayMqReceiver occur exception!!!");
                    continue;
                }
            }

            try {
                mess = (OrderMess) receiver.revMessage();
            } catch (NullPointerException e) {
                continue;
            } catch (JMSException jmse) {
                receiver = null;
                continue;
            } catch (Exception e) {
                ExcepPrinter.print(e);
                continue;
            }
            try {
                if (mess instanceof PayResult)
                    payResultMess(mess);
                else
                    otherOrderMess(mess);
            } catch (Exception e) {
                ExcepPrinter.print(e);
            }
        }
    }

    private long updateSleep() {
        try {
            return Long.parseLong(LoadXmlConfig.getConfigHash().get("mqreceiver-sleep"));
        } catch (Exception e) {
            return 1000l;
        }
    }

    private void payResultMess(OrderMess mess) {
        PayResult payResult = (PayResult) mess;
        try {
            KabInfo kabInfo = KabTeam.getInstance().getKab(payResult.getSrcMsID());
            kabInfo.getSession().write(payResult);
            OrderLogger.getLogger().debug("TaxiPayMqReceiver handle PayResult:" + payResult.toString());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }

    private void otherOrderMess(OrderMess mess) {
        OrderLogger.getLogger().debug("TaxiPayMqReceiver rev other mess!" + mess.toString());
    }
}
