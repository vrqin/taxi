package com.speedtalk.order.engine;

import com.speedtalk.order.engine.db.TabPhonecallbuss;
import com.speedtalk.order.engine.kabs.KabInfo;
import com.speedtalk.order.engine.kabs.KabTeam;
// import com.speedtalk.protocol.order.objs.NewOrder;
import com.speedtalk.protocol.order.objs.NewOrder;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;

import java.util.Iterator;

public class OrderSender implements Runnable {
    public OrderSender() {
    }

    public static double calDistance(double curr_lt, double curr_lg, double last_lt, double last_lg) {
        double PI = 3.14159265D;
        double R = 6371229.0D;
        double x = (last_lg - curr_lg) * PI * R * Math.cos((curr_lt + last_lt) / 2.0D * PI / 180.0D) / 180.0D;
        double y = (last_lt - curr_lt) * PI * R / 180.0D;
        double nRet = Math.hypot(x, y);
        return nRet;
    }

    public void run() {
        long sleep = 3000L;
        int range = 3000;
        TabPhonecallbuss order = null;
        NewOrder newOrder = null;
        boolean var6 = false;

        while (true) {
            try {
                try {
                    range = Integer.parseInt((String) LoadXmlConfig.getConfigHash().get("range")) * 1000;
                } catch (Exception var11) {
                    ;
                }

                order = Orders.getInstance().getNewOrder();
                if (order != null) {
                    int i = 0;
                    Iterator var8 = KabTeam.getInstance().getOnlineKabs().iterator();

                    while (var8.hasNext()) {
                        KabInfo info = (KabInfo) var8.next();

                        try {
                            double distance = calDistance(order.getLt(), order.getLg(), info.getLt(), info.getLg());
                            if (distance <= (double) range) {
                                newOrder = new NewOrder(info.getId(), info.getName(), order.getClientmobile(), order.getAddress(), String
                                        .valueOf(order.getSrclg()), String.valueOf(order.getSrclt()), order.getAddress(), String
                                        .valueOf(order.getLg()), String.valueOf(order.getLt()));
                                info.getSession().write(info);
                                OrderLogger.log(newOrder.toString());
                                ++i;
                            }
                        } catch (Exception var13) {
                            ;
                        }
                    }

                    OrderLogger.log(order.toString() + "-->>" + i);
                }

                sleep = (long) Integer.parseInt((String) LoadXmlConfig.getConfigHash().get("send-order-sleep"));
            } catch (Exception var14) {
                ExcepPrinter.print(var14);
            }

            try {
                Thread.sleep(sleep);
            } catch (Exception var12) {
                ;
            }
        }
    }
}
