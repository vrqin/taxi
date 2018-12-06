package com.speedtalk.oldprotol.processors;

import com.speedtalk.KabConstants;
import com.speedtalk.StartUp;
import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.session.IoSession;

public class OldOtherProcessor extends AbstractOldProcessor {
    @Override
    public void process(IoSession arg0, Mess arg1) {
        try {
            StartUp.LOG.debug(KabConstants.OLD_PROTOCOL + "Rev other message:" + arg1.toString());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }

    @Override
    public void process(IoSession arg0, TSCObject arg1) {
        // TODO Auto-generated method stub
    }
}
