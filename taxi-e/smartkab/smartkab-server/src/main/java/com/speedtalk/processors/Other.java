package com.speedtalk.processors;

import com.speedtalk.KabConstants;
import com.speedtalk.StartUp;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.tsc.handler.AbstractProcessor;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.session.IoSession;

public class Other extends AbstractProcessor {
    @Override
    public void process(IoSession arg0, TSCObject arg1) {
        try {
            StartUp.LOG.debug(KabConstants.PHOENIX_PROTOCOL + "Rev other message:" + arg1.toString());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
