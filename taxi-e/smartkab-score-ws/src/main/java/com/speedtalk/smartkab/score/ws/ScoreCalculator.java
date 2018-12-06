package com.speedtalk.smartkab.score.ws;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.mq.MQReceiver;

import javax.jms.JMSException;
import java.util.logging.Logger;

public class ScoreCalculator implements Runnable {
    private static final Logger LOG = Logger.getLogger(ScoreCalculator.class.getName());
    private String mqAddr;
    private String queueName;
    private MQReceiver receiver;
    private boolean isRun;

    public ScoreCalculator(String mqAddr, String queueName) {
        this.mqAddr = mqAddr;
        this.queueName = queueName;
        this.isRun = true;
        try {
            this.initMqReceiver();
        } catch (JMSException jme) {
            jme.printStackTrace();
            LOG.info("init ScoreCalculator occur exception!!!");
        }
    }

    public void setRun(boolean isRun) {
        this.isRun = isRun;
    }

    private void initMqReceiver() throws JMSException {
        this.receiver = new MQReceiver(mqAddr, queueName);
    }

    @Override
    public void run() {
        LOG.info("ScoreCalculator is running...");
        TSCObject mess;
        ICalculator calculator;
        while (isRun) {
            if (null == this.receiver) {
                try {
                    this.initMqReceiver();
                } catch (JMSException jme) {
                    LOG.info("***********init ScoreCalculator occur exception!!!");
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    continue;
                }
            }
            try {
                mess = this.receiver.revMessage();
            } catch (JMSException jmse) {
                jmse.printStackTrace();
                this.receiver = null;
                continue;
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            calculator = ScoreCalculatorFactory.getInstance().getCalculator(mess);
            calculator.cal(mess);
        }
        LOG.info("ScoreCalculator thread exit...");
    }
}
