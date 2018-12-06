package com.speedtalk.protocol.order.mq;

import com.speedtalk.protocol.TSCObject;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.print.attribute.standard.Destination;

/**
 * ActiveMQ Sender
 *
 * @author chen
 */
public class MQSender {
    private String queueName;
    private String mqAddr;
    private ConnectionFactory cf;
    private Connection conn;
    private Session session;
    private Destination dest;
    private MessageProducer producer;

    public MQSender(String mqAddr, String queueName) throws JMSException {
        this.mqAddr = mqAddr;
        this.queueName = queueName;

        this.init();
    }

    private void init() throws JMSException {
        cf = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, mqAddr);

        conn = cf.createConnection();
        conn.start();
        session = conn.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        dest = session.createQueue(queueName);
        producer = session.createProducer(dest);
    }

    public String getQueueName() {
        return queueName;
    }

    public String getMqAddr() {
        return mqAddr;
    }

    public void close() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean sendMessage(TSCObject obj) throws JMSException {
        try {
            producer.send(session.createObjectMessage(obj));
        } catch (JMSException jmse) {
            close();
            init();
            producer.send(session.createObjectMessage(obj));
        }
        return true;
    }
}
