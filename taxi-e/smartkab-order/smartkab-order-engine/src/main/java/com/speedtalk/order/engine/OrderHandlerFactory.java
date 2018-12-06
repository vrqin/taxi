package com.speedtalk.order.engine;

import com.speedtalk.order.engine.handler.*;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.order.objs.OrderMess;
import com.speedtalk.utils.ExcepPrinter;

import java.util.concurrent.ConcurrentHashMap;

public class OrderHandlerFactory {
    private static final ConcurrentHashMap<String, IOrderHandler> HANDLER_MAP = new ConcurrentHashMap<>();
    private static OrderHandlerFactory instance;
    private DefaultHandler defaultHandler = new DefaultHandler();
    private OrderTrackHandler orderTrackHandler = new OrderTrackHandler();

    private OrderHandlerFactory() {
        HANDLER_MAP.put(OrderMessConstants.NEW_ORDER_RESP, new ReceiveOrderHandler());
        HANDLER_MAP.put(OrderMessConstants.ACCEPT_ORDER, new AcceptOrderHandler());
        HANDLER_MAP.put(OrderMessConstants.DROP_ORDER, new DropOrderHandler());
        HANDLER_MAP.put(OrderMessConstants.LOGIN, new LoginHandler());
        HANDLER_MAP.put(OrderMessConstants.LOGOUT, new LogoutHandler());
        HANDLER_MAP.put(OrderMessConstants.UPDATE_DRIVER_INFO, new UpdateDriverHandler());
        HANDLER_MAP.put(OrderMessConstants.UPDATE_PWD, new UpdatePwdHandler());
        HANDLER_MAP.put(OrderMessConstants.GET_PASSENGER, orderTrackHandler);
        HANDLER_MAP.put(OrderMessConstants.ARRIVED, orderTrackHandler);
        HANDLER_MAP.put(OrderMessConstants.LOGIN_EXT, new LoginExtHandler());
        HANDLER_MAP.put(OrderMessConstants.PAY_INFO, new PayInfoHandler());
        HANDLER_MAP.put(OrderMessConstants.COMMOM_CONFIRM, new CommonConfirmHandler());
    }

    public static OrderHandlerFactory getInstance() {
        if (null == instance)
            instance = new OrderHandlerFactory();
        return instance;
    }

    public DefaultHandler getDefaultHandler() {
        return defaultHandler;
    }

    public IOrderHandler getHandler(TSCObject obj) {
        try {
            OrderMess orderMess = (OrderMess) obj;
            IOrderHandler handler = HANDLER_MAP.get(orderMess.getOrderMessId());
            if (null == handler)
                return defaultHandler;
            else
                return handler;
        } catch (Exception e) {
            ExcepPrinter.print(e);
            return defaultHandler;
        }
    }
}
