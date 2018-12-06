package com.speedtalk.processors;

import com.speedtalk.KabConstants;
import com.speedtalk.StartUp;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.tscobjs.SMS;
import com.speedtalk.smartkab.ws.dao.OrderDao;
import com.speedtalk.tsc.handler.AbstractProcessor;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.session.IoSession;

public class Sms extends AbstractProcessor {
    private OrderDao orderDao = new OrderDao();

    public static void main(String[] args) {
        String[] content = "ORDER|160229182852000|2|".split("\\|");
        System.out.println(content[0] + "," + content[1] + "," + content[2]);
    }

    @Override
    public void process(IoSession arg0, TSCObject arg1) {
        try {
            SMS sms = (SMS) arg1;
            StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + "SMS:" + sms.toString());
            if (sms.getContent().startsWith(KabConstants.ORDER_SMS_PRIFIX)) {
                StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + "SMS content:" + sms.getContent());
                String[] content = sms.getContent().split("\\|");
                System.out.println(content[0] + "," + content[1] + "," + content[2]);
                if (content[2].equals("2")) {
                    orderDao.acceptOrder(content[1], sms.getSrcMsID(), sms.getMsName());
                    StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + sms.getSrcMsID() + "接受电召单:" + content[1]);
                }
            } else
                StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + " sms");
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
