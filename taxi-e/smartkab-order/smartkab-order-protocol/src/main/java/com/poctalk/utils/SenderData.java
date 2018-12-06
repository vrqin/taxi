package com.poctalk.utils;


import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class SenderData<T> {
    private static final CharsetEncoder encoder = Charset.defaultCharset().newEncoder();
    private static Logger cmdLog = Logger.getLogger("cmd");

    public SenderData() {
    }

    public static void senderUdpData(IoConnector connector, String ip, int port, final AbstractTcspMessage msg) {
        ConnectFuture cf = null;

        try {
            cf = connector.connect(new InetSocketAddress(InetAddress.getByName(ip), port));
        } catch (UnknownHostException var6) {
            ExcepPrinter.print(var6);
        }

        cf.awaitUninterruptibly();
        cf.addListener(new IoFutureListener<ConnectFuture>() {
            public void operationComplete(ConnectFuture future) {
                if (future.isConnected()) {
                    IoSession session = future.getSession();

                    try {
                        IoBuffer resp = msg.messageToBytes(SenderData.encoder);
                        session.write(resp);
                        TcspCommandCalculate.tscAllSenderAdd();
                        if (msg.getWriteLog() == 1) {
                            SenderData.cmdLog.debug(msg.toString() + ",Address:" + session.getRemoteAddress() + ",Data:" + StringUtils
                                    .buff2HexAsciiString(resp.array()));
                        }
                    } catch (Exception var4) {
                        ExcepPrinter.print(var4);
                    }
                } else {
                    try {
                        throw new Exception(" 连接错误。");
                    } catch (Exception var5) {
                        ExcepPrinter.print(var5);
                    }
                }

            }
        });
        cf.cancel();
    }

    public static boolean senderHb(IoConnector connector, String threadName) {
        Hb hb = new Hb();
        hb.setSeqID(NumberUtils.getNextSeqNumber());
        hb.setMsID(threadName);
        String[] ips = ((String) LoadXmlConfig.getConfigHash().get("senderThreadHbToServerIP")).split(",");
        String[] ports = ((String) LoadXmlConfig.getConfigHash().get("senderThreadHbToServerPort")).split(",");
        if (ips != null && ports != null) {
            if (ips.length != ports.length) {
                return false;
            } else {
                for (int i = 0; i < ips.length; ++i) {
                    senderUdpData(connector, ips[i], Integer.parseInt(ports[i]), hb);
                }

                return true;
            }
        } else {
            return false;
        }
    }
}
