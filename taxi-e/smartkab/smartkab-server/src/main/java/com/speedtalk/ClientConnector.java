package com.speedtalk;

import com.speedtalk.codec.GetCodecFactory;
import com.speedtalk.tsc.comm.Constants;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;

public class ClientConnector {
    private static ClientConnector instance = new ClientConnector();
    private NioSocketConnector connector;
    private String ip;
    private int port;

    private ClientConnector() {
        try {
            this.initServInfo();
        } catch (Exception e) {
            System.out.println(KabConstants.getPhoenixLogPrefix() + "Please check <sip> and <tport> in config.xml");
            // System.exit(0);
        }
    }

    public static ClientConnector getInstance() {
        return instance;
    }

    public NioSocketConnector getConnector() {
        return connector;
    }

    private void initServInfo() throws Exception {
        try {
            ip = LoadXmlConfig.getConfigHash().get("sip");
            port = Integer.parseInt(LoadXmlConfig.getConfigHash().get("tport"));
        } catch (Exception e) {
            throw e;
        }
    }

    public ConnectFuture connect() throws Exception {
        // try {
        //     initServInfo();
        // } catch (Exception e) {
        //     ExcepPrinter.print(e);
        //     return;
        // }
        connector = new NioSocketConnector();
        // connector.getFilterChain()
        //         .addLast("Phoenix", new ProtocolCodecFilter(new PhoenixCodecFactory(Charset.forName(StartUp.SERV_CHARSET))));
        connector.getFilterChain()
                .addLast("Phoenix", new ProtocolCodecFilter(GetCodecFactory.getInstance()
                        .getCodecFactory(StartUp.SERV_CHARSET)));
        connector.setHandler(new ClientHandler());
        connector.getSessionConfig().setReaderIdleTime(Constants.IDLE_TIME);
        connector.getSessionConfig().setWriterIdleTime(Constants.IDLE_TIME);
        try {
            connector.setConnectTimeoutMillis(10);
            ConnectFuture future = connector.connect(new InetSocketAddress(ip, port));
            future.awaitUninterruptibly();
            // StartUp.LOG.debug(KabConstants.PHOENIX_LOG + "After connect!" + future.isConnected()
            // 	+ "," + future.isDone() + ","
            // 	+ PhoenixClientInfo.getInstance().getMsId());
            return future;
        } catch (Exception e) {
            throw e;
        }
    }

    public ConnectFuture reConnect() throws Exception {
        closeConnector();
        try {
            initServInfo();

        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        try {
            return connect();
        } catch (Exception e) {
            throw e;
        }
    }

    public void closeConnector() {
        try {
            connector.dispose(false);
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
