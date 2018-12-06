package com.speedtalk.order.engine;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.mq.MQSender;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;

import javax.jms.JMSException;

public class ScoreMqSender {
    private static ScoreMqSender instance = new ScoreMqSender();
    private MQSender sender = null;

    private ScoreMqSender() {
        init();
    }

    public static ScoreMqSender getInstance() {
        if (null == instance)
            instance = new ScoreMqSender();
        return instance;
    }

    private void init() {
        String mqAddr = LoadXmlConfig.getConfigHash().get("mq-addr");
        String queueName = LoadXmlConfig.getConfigHash().get("etoscore-queue");
        try {
            sender = new MQSender(mqAddr, queueName);
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }

    public String getMqAddr() {
        try {
            return sender.getMqAddr();
        } catch (Exception e) {
        }
        return null;
    }

    public String getQueueName() {
        try {
            return sender.getQueueName();
        } catch (Exception e) {
        }
        return null;
    }

    public void sendMessage(TSCObject obj) throws JMSException {
        sender.sendMessage(obj);
    }
}
