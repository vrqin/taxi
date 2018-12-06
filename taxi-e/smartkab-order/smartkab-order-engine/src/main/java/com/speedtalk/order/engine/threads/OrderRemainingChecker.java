package com.speedtalk.order.engine.threads;

import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.protocol.order.objs.OrderSms;
import com.speedtalk.utils.LoadXmlConfig;

import java.util.concurrent.TimeUnit;

/**
 * 定时检测由于司机接单次数为0，不能接单的司机，并发送通知消息
 *
 * @author chen
 */
public class OrderRemainingChecker implements Runnable {
    @Override
    public void run() {
        int sleep = 30;
        String sms = null;
        OrderSms orderSms = null;
        StringBuilder log = new StringBuilder("发送接单次数为0的通知给:");
        int fixedLen = log.length();
        OrderLogger.getLogger().debug("OrderRemainingChecker is running...");
        while (true) {
            try {
                sleep = Integer.parseInt(LoadXmlConfig.getConfigHash().get("order-remain-check-interval"));
            } catch (Exception e) {
            }
            try {
                TimeUnit.MINUTES.sleep(sleep);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }

            sms = LoadXmlConfig.getConfigHash().get("forbid-order-sms");
            if (null == sms || sms.trim().equals("")) {
                OrderLogger.getLogger().debug("======= Not config <forbid-order-sms>!!!");
                continue;
            }

            log.setLength(fixedLen);
            for (KabInfo info : KabTeam.getInstance().getForbidOrderKab()) {
                try {
                    orderSms = new OrderSms(info.getAccount(), info.getName(), sms);
                    info.getSession().write(orderSms);
                    log.append(info.getAccount()).append(",");
                } catch (Exception e) {
                }
            }
            if (log.length() > fixedLen)
                OrderLogger.getLogger().debug(log.toString());
        }
    }
}
