package com.speedtalk.protocol.order.mq;

import com.speedtalk.protocol.TSCObject;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ActiveMQ Receiver
 *
 * @author chen
 */
public class MQReceiver {
    private ConnectionFactory cf;
    private Connection conn;
    private Session session;
    private Destination dest;
    private MessageConsumer consumer;
    private String mqAddr;
    private String queueName;

    public MQReceiver(String mqAddr, String queueName) throws JMSException {
        this.mqAddr = mqAddr;
        this.queueName = queueName;

        cf = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, mqAddr);
        conn = cf.createConnection();
        conn.start();

        session = conn.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        dest = session.createQueue(queueName);
        consumer = session.createConsumer(dest);
    }

    public String getMqAddr() {
        return mqAddr;
    }

    public String getQueueName() {
        return queueName;
    }

    public TSCObject revMessage() throws JMSException {
        ObjectMessage mess = (ObjectMessage) consumer.receive();
        if (mess != null)
            return (TSCObject) mess.getObject();
        return null;
    }
}
