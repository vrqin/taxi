package com.speedtalk.order.server;

import com.speedtalk.codec.PhoenixCodecFactory;
import com.speedtalk.protocol.utils.StringUtils;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 服务端的接收器。
 * 使用该类时:1、必须提供IO事件处理类，setIoHandler(IoHandlerAdapter ioHandler)
 * 2、该连接器依赖框架MINA 2.0。
 *
 * @author chen
 */
public class TcpAcceptor {
    private static TcpAcceptor instance = new TcpAcceptor();
    private NioSocketAcceptor acceptor;
    private IoHandlerAdapter ioHandler;
    private LinkedHashMap<String, IoFilter> filterMap;
    private int readIdle;
    private int writeIdle;

    private TcpAcceptor() {
        readIdle = 5;
        writeIdle = 5;
    }

    public static TcpAcceptor getInstance() {
        return instance;
    }

    public NioSocketAcceptor getAcceptor() {
        return acceptor;
    }

    /**
     * 获取IO事件处理类
     *
     * @return IoHandlerAdapter
     */
    public IoHandlerAdapter getIoHandler() {
        return ioHandler;
    }

    /**
     * 设置IO事件处理类
     * 必须提供
     *
     * @param ioHandler
     */
    public void setIoHandler(IoHandlerAdapter ioHandler) {
        this.ioHandler = ioHandler;
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

    /**
     * 启动服务端
     *
     * @param port 服务端监听端口
     * @throws NullPointerException ioHandler is null
     * @throws IOException          绑定port出现异常
     */
    public void startUp(int port) throws NullPointerException, IOException {
        if (null == ioHandler)
            throw new NullPointerException("IoHandler is NULL!");
        acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain()
                .addLast("PHOENIX", new ProtocolCodecFilter(new PhoenixCodecFactory(Charset.forName(StringUtils.getEncoding()))));
        acceptor.setHandler(ioHandler);
        acceptor.setReuseAddress(true);
        acceptor.getSessionConfig().setReaderIdleTime(readIdle);
        acceptor.getSessionConfig().setWriterIdleTime(writeIdle);
        if (filterMap != null) {
            for (Map.Entry<String, IoFilter> entry : filterMap.entrySet())
                acceptor.getFilterChain().addLast(entry.getKey(), entry.getValue());
        }
        try {
            acceptor.bind(new InetSocketAddress(port));
        } catch (IOException ioe) {
            throw ioe;
        }
    }


    /**
     * 关闭服务端
     */
    public void closeAcceptor() {
        acceptor.dispose(false);
    }
}
