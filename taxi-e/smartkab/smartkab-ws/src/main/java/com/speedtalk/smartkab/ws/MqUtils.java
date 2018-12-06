package com.speedtalk.smartkab.ws;

import com.speedtalk.protocol.order.mq.MQSender;
import com.speedtalk.utils.LoadXmlConfig;

import javax.jms.JMSException;

public class MqUtils {
    private static MqUtils instance = new MqUtils();
    private MQSender sender;

    //	private MQReceiver receiver;
    private MqUtils() {
        intiSender();
        // intiReceiver();

    }

    public static MqUtils getInstance() {
        return instance;
    }

    // private void intiReceiver() {
    //     try {
    //         receiver = new MQReceiver("tcp://192.168.1.251:61616", "engine_to_ws");
    //         // receiver = new MQReceiver("tcp://127.0.0.1:61616", "engine_to_ws");
    //     } catch (JMSException e) {
    //         System.out.println("init ActiveMq Receiver occur exception!");
    //         e.printStackTrace();
    //     }
    // }

    private void intiSender() {
        try {
            //			sender = new MQSender("tcp://192.168.1.251:61616","ws_to_engine");
            //			sender = new MQSender("tcp://127.0.0.1:61616","ws_to_engine");
            sender = new MQSender(LoadXmlConfig.getConfigHash().get("queue_addr"), "ws_to_engine");
        } catch (JMSException e) {
            System.out.println("init ActiveMq Sender occur exception!");
            e.printStackTrace();
        }
    }

    public MQSender getSender() {
        return sender;
    }

    public MQSender getNewSender() {
        intiSender();
        return sender;
    }

    // public MQReceiver getNewReceiver() {
    //     intiReceiver();
    //     return receiver;
    // }
    //
    // public MQReceiver getReceiver() {
    //     return receiver;
    // }
    public String getSenderInfo() {
        return "Sender:" + sender.getMqAddr() + ":" + sender.getQueueName();
    }

    // public String getReceiverInfo() {
    //     return "Receiver:" + receiver.getMqAddr() + ":" + receiver.getQueueName();
    // }
}
