package com.speedtalk.smartkab.pay.ws;

import com.speedtalk.protocol.order.mq.MQSender;
import com.speedtalk.utils.LoadXmlConfig;

import javax.jms.JMSException;

public class MqUtils {
    private static MqUtils instance = new MqUtils();
    private MQSender sender;

    private MqUtils() {
        intiSender();
    }

    public static MqUtils getInstance() {
        return instance;
    }

    private void intiSender() {
        try {
            sender = new MQSender(LoadXmlConfig.getConfigHash().get("queue_addr"), "pay_to_engine");
        } catch (JMSException e) {
            System.out.println("init ActiveMq Sender occur exception!");
            e.printStackTrace();
        }
    }

    public MQSender getSender() {
        return sender;
    }

    public MQSender getNewSender() {
        this.intiSender();
        return sender;
    }

    public String getSenderInfo() {
        return "Sender:" + sender.getMqAddr() + ":" + sender.getQueueName();
    }
}
