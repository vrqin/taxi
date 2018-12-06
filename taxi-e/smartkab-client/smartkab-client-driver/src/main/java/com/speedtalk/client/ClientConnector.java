package com.speedtalk.client;

import com.speedtalk.codec.PhoenixCodecFactory;
import com.speedtalk.protocol.utils.StringUtils;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 客户端的连接器。
 * 使用该类时:1、必须先<b>通过ClientInfo设置服务端的IP和端口</b>。
 * 2、必须提供IO事件处理类，setClientIoHandler(IoHandlerAdapter clientIoHandler)
 * 3、该连接器依赖框架MINA 2.0。
 *
 * @author chen
 */
public class ClientConnector {
    private static ClientConnector instance = new ClientConnector();
    private NioSocketConnector connector;
    private IoHandlerAdapter clientIoHandler;
    private LinkedHashMap<String, IoFilter> filterMap;
    private int readIdle;
    private int writeIdle;
    private long timeoutMillis;

    private ClientConnector() {
        readIdle = 5;
        writeIdle = 5;
        timeoutMillis = 5000;
    }

    public static ClientConnector getInstance() {
        return instance;
    }

    public NioSocketConnector getConnector() {
        return connector;
    }

    /**
     * 获取IO事件处理类
     *
     * @return IoHandlerAdapter
     */
    public IoHandlerAdapter getClientIoHandler() {
        return clientIoHandler;
    }

    /**
     * 设置IO事件处理类
     * 必须提供
     *
     * @param clientIoHandler
     */
    public void setClientIoHandler(IoHandlerAdapter clientIoHandler) {
        this.clientIoHandler = clientIoHandler;
    }

    /**
     * 获取接收数据空闲超时时间
     *
     * @return 超时时间（秒）
     */
    public int getReadIdle() {
        return readIdle;
    }

    /**
     * 设置接收数据空闲超时时间，默认是5秒。
     * <b>在调用connect()方法前设置</b>
     *
     * @param seconds 超时时间（秒）
     */
    public void setReadIdle(int seconds) {
        this.readIdle = seconds;
    }

    /**
     * 获取发送数据空闲超时时间
     *
     * @return 超时时间（秒）
     */
    public int getWriteIdle() {
        return writeIdle;
    }

    /**
     * 设置发送数据空闲超时时间，默认是5秒。
     * <b>在调用connect()方法前设置</b>
     *
     * @param seconds 超时时间（秒）
     */
    public void setWriteIdle(int seconds) {
        this.writeIdle = seconds;
    }

    /**
     * 获取用户自定义过滤器链
     *
     * @return 过滤器链
     */
    public LinkedHashMap<String, IoFilter> getFilterMap() {
        return filterMap;
    }

    /**
     * 设置用户自定义定义过滤器链，
     * 该过滤器链将按顺序添加。
     *
     * @param filterMap 过滤器链
     */
    public void setFilterMap(LinkedHashMap<String, IoFilter> filterMap) {
        this.filterMap = filterMap;
    }

    public long getTimeoutMillis() {
        return timeoutMillis;
    }

    /**
     * 设置超时
     *
     * @param timeoutMillis（毫秒）
     */
    public void setTimeoutMillis(long timeoutMillis) {
        this.timeoutMillis = timeoutMillis;
    }

    /**
     * 连接服务端方法。
     * 当通过ClientInfo设置好服务端的IP和端口，
     * 就可以调用该方法连接服务端
     *
     * @return ConnectFuture对象
     * @throws NullPointerException clientIoHandler为空
     */
    public ConnectFuture connect() throws NullPointerException {
        if (null == clientIoHandler)
            throw new NullPointerException("clientIoHandler is NULL!");
        connector = new NioSocketConnector();
        connector.getFilterChain()
                .addLast("Phoenix", new ProtocolCodecFilter(new PhoenixCodecFactory(Charset.forName(StringUtils.getEncoding()))));
        if (filterMap != null) {
            for (Map.Entry<String, IoFilter> entry : filterMap.entrySet())
                connector.getFilterChain().addLast(entry.getKey(), entry.getValue());
        }
        connector.setHandler(clientIoHandler);
        connector.setConnectTimeoutMillis(timeoutMillis);
        ConnectFuture future = connector.connect(new InetSocketAddress(ClientInfo.getInstance()
                .getServerIp(), ClientInfo.getInstance().getServerPort()));
        future.awaitUninterruptibly();
        System.out.println(future.getSession().getLocalAddress().toString());
        return future;
    }

    /**
     * 重新连接服务端。
     * 使用该方法，无须先调用closeConnector方法。
     */
    public ConnectFuture reConnect() {
        closeConnector();
        return connect();
    }

    /**
     * 关闭和服务端的连接
     */
    public void closeConnector() {
        try {
            connector.dispose(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
