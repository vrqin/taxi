package com.speedtalk;

import com.speedtalk.oldprotol.AdapterFactory;
import com.speedtalk.oldprotol.ProtolAdapter;
import com.speedtalk.oldprotol.UnsupportedAdaptException;
import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.tscobjs.HB;
import com.speedtalk.protocol.tscobjs.Login;
import com.speedtalk.tsc.comm.Constants;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.List;

public class ClientHandler extends IoHandlerAdapter {
    private Login login = new Login("");
    private HB hb = new HB();

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        ExcepPrinter.printThrow(cause);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        try {
            if (LoadXmlConfig.getConfigHash().get("protocol").equals(KabConstants.OLD_PROTOCOL)) {
                StartUp.LOG.debug(KabConstants.getOldLogPrefix() + ":" + message.toString());
                try {
                    ProtolAdapter adapter = AdapterFactory.getInstance().getAdapter((Mess) message);
                    List<TSCObject> list = adapter.adapt((Mess) message);
                    for (TSCObject obj : list)
                        ProcessorFactory.getInstance().getProcessor(obj).process(session, obj);
                } catch (UnsupportedAdaptException uae) {
                    ProcessorFactory.getInstance().getProcessor((Mess) message).process(session, (Mess) message);
                }

            } else {
                TSCObject obj = (TSCObject) message;
                StartUp.LOG.debug(KabConstants.PHOENIX_PROTOCOL + " Receive:" + obj.toString() + "," + obj.getMessID());
                ProcessorFactory.getInstance().getProcessor(obj).process(session, obj);
            }
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        ClientInfo.getInstance().setLogin(false);
        StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + "session closed!Reconnect server...");
        try {
            ConnectFuture future = ClientConnector.getInstance().reConnect();
            while (!future.isConnected()) {
                try {
                    Thread.sleep(Integer.parseInt(LoadXmlConfig.getConfigHash().get("reconnect-interval")) * 1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                future = ClientConnector.getInstance().reConnect();
                StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + "Reconnect failure,continue...");
            }
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        StartUp.LOG.debug("Connect server success!!!");
        String msId = LoadXmlConfig.getConfigHash().get("msid");
        String pwd = LoadXmlConfig.getConfigHash().get("pwd");
        if (msId == null || msId.equals("")) {
            StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + "The <msid> config is incorrect *****");
            return;
        }
        if (pwd == null || pwd.equals("")) {
            StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + "The <pwd> config is null *****");
            return;
        }
        login.setMessNo(ClientInfo.getInstance().getFirstMessNo());
        login.setSrcMsID(msId);
        login.setPwd(pwd);
        session.write(login);
        StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + "Logining server！MsId is " + msId);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        // 最大空闲次数
        int maxIdleCount = (int) (ClientInfo.getInstance().getHbInterval() / Constants.IDLE_TIME);
        int writeIdleCount = session.getWriterIdleCount();
        // 写超时，发送心跳
        if (writeIdleCount >= maxIdleCount) {
            hb.setSrcMsID(ClientInfo.getInstance().getMsId());
            hb.setMessNo(ClientInfo.getInstance().getMessNo());
            session.write(hb);
            StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + "Send Hb ...");
        }
        int readIdleCount = session.getReaderIdleCount();
        // 读超过 (maxIdleCount + 1) * Constants.IDLE_TIME 秒，重连
        if (readIdleCount > maxIdleCount + 1) {
            StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + (maxIdleCount + 1) * Constants.IDLE_TIME + " second read nothing,will reconnect ...");
            session.close(true);
        }
    }
}
