package com.speedtalk.tsc.handler;

import com.speedtalk.protocol.TSCObject;
import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;

public abstract class AbstractProcessor {
    protected Logger cmdLog = Logger.getLogger("cmd");
    protected Logger cnsleLog = Logger.getLogger("cnsle");

    public AbstractProcessor() {
    }

    public abstract void process(IoSession var1, TSCObject var2);
}
