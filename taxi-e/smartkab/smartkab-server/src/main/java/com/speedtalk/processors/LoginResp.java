package com.speedtalk.processors;

import com.speedtalk.ClientInfo;
import com.speedtalk.KabConstants;
import com.speedtalk.StartUp;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.RespConstants;
import com.speedtalk.tsc.handler.AbstractProcessor;
import com.speedtalk.utils.ExcepPrinter;
import com.speedtalk.utils.LoadXmlConfig;
import org.apache.mina.core.session.IoSession;

public class LoginResp extends AbstractProcessor {
    //	private HB hb = new HB();
    @Override
    public void process(IoSession arg0, TSCObject arg1) {
        try {
            com.speedtalk.protocol.tscobjs.LoginResp resp = (com.speedtalk.protocol.tscobjs.LoginResp) arg1;
            if (RespConstants.SUCCESS == resp.getResult()) {
                ClientInfo.getInstance().setMsId(resp.getSrcMsID());
                ClientInfo.getInstance().setPwd(LoadXmlConfig.getConfigHash().get("pwd"));
                //				if(!ClientInfo.getInstance().isLogin())
                //					new Thread(new GetKabs()).start();
                ClientInfo.getInstance().setSession(arg0);
                ClientInfo.getInstance().setLogin(true);
                StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + "Login success!!!");
            }
            StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + resp.toString());

            //			hb.setSrcMsID(ClientInfo.getInstance().getMsId());
            //			hb.setMessNo(ClientInfo.getInstance().getMessNo());
            //			arg0.write(hb);
            //			StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + "Send Hb ...");
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
