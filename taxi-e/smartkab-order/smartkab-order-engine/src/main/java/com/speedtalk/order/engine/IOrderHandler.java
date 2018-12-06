package com.speedtalk.order.engine;

import com.speedtalk.protocol.TSCObject;
import org.apache.mina.core.session.IoSession;

public interface IOrderHandler {
    void handler(IoSession session, TSCObject obj);
}
