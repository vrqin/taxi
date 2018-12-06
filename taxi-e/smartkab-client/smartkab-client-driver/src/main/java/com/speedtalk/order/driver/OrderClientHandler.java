package com.speedtalk.order.driver;

import com.speedtalk.client.ClientConnector;
import com.speedtalk.client.ClientInfo;
import com.speedtalk.protocol.order.OrderMessConstants;
import com.speedtalk.protocol.order.objs.*;
import com.speedtalk.protocol.tscobjs.GPS;
import com.speedtalk.protocol.tscobjs.VehicleAlarm;
import com.speedtalk.protocol.tscobjs.VehicleStatus;
import com.speedtalk.protocol.utils.DateUtils;
import com.speedtalk.protocol.utils.MessageUtils;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.ArrayList;
import java.util.List;

/**
 * IO事件处理类，IO事件包括如：和服务端成功建立连接、 连接已关闭、收到服务端数据、在设定的时间内读写数据超时。
 */
public class OrderClientHandler extends IoHandlerAdapter {
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
    }

    /**
     * 接收到服务端的数据
     */
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        try {
            if (message instanceof OrderMess) {
                OrderMess orderMess = (OrderMess) message;
                if (orderMess.getOrderMessId().equals(OrderMessConstants.LOGIN_RESP)) {
                    // 这里添加对具体指令的处理
                    System.out.println("rev LoginResp :" + (orderMess).toString() + ",Session id:" + ClientInfo.getInstance()
                            .getSession()
                            .getId());
                    // OrderLoginResp resp = (OrderLoginResp) orderMess;
                    GPS gps = new GPS(23.169429, 113.429257, (short) 21, 25.12f, (short) 121, DateUtils.getCommonTimeFormat()
                            .format(System.currentTimeMillis()), 36.5f, 20f, new VehicleStatus(), new VehicleAlarm());
                    gps.setSrcMsID(ClientInfo.getInstance().getId());
                    gps.setMessNo(MessageUtils.getMessNo());
                    session.write(gps);

                    UpdatePwd pwd = new UpdatePwd(ClientInfo.getInstance().getId(), ClientInfo.getInstance()
                            .getName(), "123456", "123456");
                    session.write(pwd);

                    new Thread(new GpsSender(session)).start();
                } else if (orderMess.getOrderMessId()
                        .equals(OrderMessConstants.LOGOUT_RESP) || orderMess.getOrderMessId()
                        .equals(OrderMessConstants.UPDATE_DRIVER_INFO_RESP) || orderMess.getOrderMessId()
                        .equals(OrderMessConstants.UPDATE_PWD_RESP)) {
                    System.out.println("Resp:" + (orderMess).toString() + "," + ((Resp) orderMess).getCode());
                } else if (orderMess.getOrderMessId().equals(OrderMessConstants.NEW_ORDER)) {
                    System.out.println("New Order:" + (orderMess).toString());
                    Order acceptOrder = new Order(ClientInfo.getInstance().getId(), ClientInfo.getInstance()
                            .getName(), OrderMessConstants.ACCEPT_ORDER, ((NewOrder) orderMess).getOrderNum());
                    session.write(acceptOrder);
                } else if (orderMess.getOrderMessId().equals(OrderMessConstants.ACCEPT_ORDER_RESP)) {
                    System.out.println("Accept Order:" + (orderMess).toString());
                } else if (orderMess.getOrderMessId().equals(OrderMessConstants.DROP_ORDER)) {
                } else if (orderMess.getOrderMessId().equals(OrderMessConstants.DROP_ORDER_RESP)) {
                } else {
                }
            } else {
                System.out.println("非电召数据");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 和服务端的连接已经关闭
     */
    @Override

    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("sessionOpened...");
        ClientInfo.getInstance().setSession(null);
        /**
         * 和服务端的连接已经断开， 这里进行处理：重新连接服务端？准备退出，不重连？
         */
        // =============以下是重连代码，需要重连去掉注释=================
        ConnectFuture future = ClientConnector.getInstance().reConnect();
        while (!future.isConnected()) {
            try {
                Thread.sleep(2000); // 连接不成功，2秒后自动重连
            } catch (Exception e) {
                e.printStackTrace();
            }
            future = ClientConnector.getInstance().reConnect();
        }

    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        ClientInfo.getInstance().setSession(session);
        System.out.println("sessionCreated...");
    }

    /**
     * 和服务端成功建立连接
     */
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("sessionOpened...");
        ClientInfo.getInstance().setSession(session);
        // 发送登录指令
        OrderLogin login = new OrderLogin(ClientInfo.getInstance().getId(), ClientInfo.getInstance()
                .getName(), ClientInfo.getInstance().getPwd());
        List<String> list = new ArrayList<>();
        list.add("v1.4");
        list.add("123456");
        list.add("jefij");
        login.setAttach(list);
        session.write(login);
        System.out.println("Sent login...");
        /**
         * 已经和服务端成功建立连接，并且已经发送登录指令，这里进行其它处理
         */
    }

    /**
     * 读写数据超时
     */
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        if (session.getReaderIdleCount() > 0) {
            /**
             * 已经在ClientConnector.setReadIdle设置的时间内 没有收到数据，这里进行处理
             */
        }
        if (session.getWriterIdleCount() > 0) {
            /**
             * 已经在ClientConnector.setWriteIdle设置的时间内 没有发送数据，这里进行处理
             */
        }
    }
}
