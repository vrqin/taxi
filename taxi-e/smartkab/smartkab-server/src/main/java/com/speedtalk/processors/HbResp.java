package com.speedtalk.processors;

import com.speedtalk.ClientInfo;
import com.speedtalk.KabConstants;
import com.speedtalk.StartUp;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.tscobjs.HBResp;
import com.speedtalk.tsc.handler.AbstractProcessor;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.session.IoSession;

public class HbResp extends AbstractProcessor {
    @Override
    public void process(IoSession arg0, TSCObject arg1) {
        try {
            HBResp resp = (HBResp) arg1;
            ClientInfo.getInstance().setHbInterval(resp.getHbInterval());
            StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + resp.toString());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
