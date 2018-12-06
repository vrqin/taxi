package com.speedtalk.protocol.order;

import com.speedtalk.protocol.order.objs.OrderMess;
import com.speedtalk.protocol.tscobjs.SMS;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.WriteRequest;

public class OrderMessFilter extends IoFilterAdapter {
    @Override
    public void exceptionCaught(NextFilter nextFilter, IoSession session, Throwable cause) throws Exception {
        nextFilter.exceptionCaught(session, cause);
    }

    @Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
        if (message instanceof SMS) {
            try {
                SMS sms = (SMS) message;
                if (sms.getContent() != null && sms.getContent().startsWith(OrderMessConstants.HEAD)) {
                    OrderMess orderMess = OrderMessPaser.getInstance().parse(sms);
                    if (orderMess != null)
                        nextFilter.messageReceived(session, orderMess);
                    return;
                }
            } catch (Exception cce) {
            }
        }

        nextFilter.messageReceived(session, message);
        return;
    }

    @Override
    public void messageSent(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
        nextFilter.messageSent(session, writeRequest);
    }

    @Override
    public void sessionCreated(NextFilter nextFilter, IoSession session) throws Exception {
        nextFilter.sessionCreated(session);
    }

    @Override
    public void sessionOpened(NextFilter nextFilter, IoSession session) throws Exception {
        nextFilter.sessionOpened(session);
    }

    @Override
    public void sessionIdle(NextFilter nextFilter, IoSession session, IdleStatus status) throws Exception {
        nextFilter.sessionIdle(session, status);
    }

    @Override
    public void sessionClosed(NextFilter nextFilter, IoSession session) throws Exception {
        nextFilter.sessionClosed(session);
    }
}
