package com.speedtalk.processors;

import com.speedtalk.ClientInfo;
import com.speedtalk.KabConstants;
import com.speedtalk.StartUp;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.tscobjs.HB;
import com.speedtalk.tsc.handler.AbstractProcessor;
import org.apache.mina.core.session.IoSession;

public class Hb extends AbstractProcessor {
    private HB hb = new HB();

    @Override
    public void process(IoSession arg0, TSCObject arg1) {
        hb.setSrcMsID(ClientInfo.getInstance().getMsId());
        hb.setMessNo(ClientInfo.getInstance().getMessNo());
        arg0.write(hb);
        StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + "Send Hb ...");
    }
}
