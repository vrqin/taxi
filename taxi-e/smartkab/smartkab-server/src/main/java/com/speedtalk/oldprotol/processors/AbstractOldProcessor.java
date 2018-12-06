package com.speedtalk.oldprotol.processors;

import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.tsc.handler.AbstractProcessor;
import org.apache.mina.core.session.IoSession;

public abstract class AbstractOldProcessor extends AbstractProcessor {
    //	@Override
    //	public void process(IoSession arg0,TSCObject arg1)
    //	{
    //		// TODO Auto-generated method stub
    //	}
    public abstract void process(IoSession arg0, Mess arg1);
}
