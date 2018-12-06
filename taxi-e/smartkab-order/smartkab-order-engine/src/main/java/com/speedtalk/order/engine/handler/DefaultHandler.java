package com.speedtalk.order.engine.handler;

import com.speedtalk.order.engine.IOrderHandler;
import com.speedtalk.order.engine.OrderLogger;
import com.speedtalk.protocol.TSCObject;
import org.apache.mina.core.session.IoSession;

public class DefaultHandler implements IOrderHandler {
    @Override
    public void handler(IoSession session, TSCObject obj) {
        OrderLogger.getLogger().debug("Other message:" + obj.toString() + "--" + session.getRemoteAddress());
    }
}
