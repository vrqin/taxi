package com.speedtalk.order.engine;

import com.speedtalk.order.engine.dao.DriverDao;
import com.speedtalk.order.engine.handler.GpsHandler;
import com.speedtalk.order.engine.handler.LoginHandler;
import com.speedtalk.order.engine.kabs.KabTeam;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.order.objs.OrderMess;
import com.speedtalk.protocol.tscobjs.GPS;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * IO事件处理类，IO事件包括如：和服务端成功建立连接、 连接已关闭、收到服务端数据、在设定的时间内读写数据超时。
 *
 * @author chen
 */
public class OrderEngineHandler extends IoHandlerAdapter {
    private DriverDao driverDao = new DriverDao();
    private GpsHandler gpsHandler = new GpsHandler();

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        OrderLogger.log("kab-session exceptionCaught:" + session.getId() + ":" + session.getRemoteAddress() + ",All session:" + session
                .getService()
                .getManagedSessionCount() + ",account:" + session.getAttribute(LoginHandler.ACCOUNT_SESSION_KEY));
        ExcepPrinter.print((Exception) cause);
    }

    @Override
    /**
     * 接收到服务端的数据
     */ public void messageReceived(IoSession session, Object message) throws Exception {
        try {
            if (message instanceof OrderMess) {
                OrderMess orderMess = (OrderMess) message;
                OrderHandlerFactory.getInstance().getHandler(orderMess).handler(session, orderMess);
            } else if (message instanceof GPS) {
                gpsHandler.handler(session, (TSCObject) message);
            } else {
                // 非电召数据
                OrderHandlerFactory.getInstance().getDefaultHandler().handler(session, (TSCObject) message);
            }
        } catch (Exception e) {
        }
    }

    @Override
    /**
     * 和服务端的连接已经关闭
     */ public void sessionClosed(IoSession session) throws Exception {
        Object account = session.getAttribute(LoginHandler.ACCOUNT_SESSION_KEY);
        if (account != null) {
            driverDao.updateOnlineStatus((String) account, KabTeam.OFFLINE);
            KabTeam.getInstance().setOffLine((String) account);
        }
        OrderLogger.log("kab-session closed:" + session.getId() + ":" + session.getRemoteAddress() + ",All session:" + session
                .getService()
                .getManagedSessionCount() + ",account:" + account);
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        OrderLogger.log("kab-session created:" + session.getId() + ":" + session.getRemoteAddress() + ",All session:" + session
                .getService()
                .getManagedSessionCount() + ",account:" + session.getAttribute(LoginHandler.ACCOUNT_SESSION_KEY));
    }

    @Override
    /**
     * 和服务端成功建立连接
     */ public void sessionOpened(IoSession session) throws Exception {
        OrderLogger.log("kab-session opened:" + session.getId() + ":" + session.getRemoteAddress() + ",All session:" + session
                .getService()
                .getManagedSessionCount() + ",account:" + session.getAttribute(LoginHandler.ACCOUNT_SESSION_KEY));
    }

    @Override
    /**
     * 读写数据超时
     */ public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        if (!session.isClosing() && session.getReaderIdleCount() > 0) {
            /**
             * 已经在ClientConnector.setReadIdle设置的时间内 没有收到数据，这里进行处理
             */
            //			SocketAddress address = session.getRemoteAddress();
            //			long sessionId = session.getId();
            session.close(true);
            OrderLogger.log("kab-session idle timeout,will close!" + session.getId() + ":" + session.getRemoteAddress() + ",All session:" + session
                    .getService()
                    .getManagedSessionCount() + ",account:" + session.getAttribute(LoginHandler.ACCOUNT_SESSION_KEY));
        }
        if (session.getWriterIdleCount() > 0) {
            /**
             * 已经在ClientConnector.setWriteIdle设置的时间内 没有发送数据，这里进行处理
             */
        }
    }
}
