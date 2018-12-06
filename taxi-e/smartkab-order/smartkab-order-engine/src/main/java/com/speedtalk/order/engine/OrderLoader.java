package com.speedtalk.order.engine;

import com.speedtalk.order.engine.dao.OrderDao;

public class OrderLoader {
    private static OrderDao orderDao = new OrderDao();

    public static void loadOrders() {
        OrderLogger.log("Loading new order: " + Orders.getInstance()
                .setUnfinishedOrder(orderDao.getUnfinished(Orders.SECONDS)));
    }
}
