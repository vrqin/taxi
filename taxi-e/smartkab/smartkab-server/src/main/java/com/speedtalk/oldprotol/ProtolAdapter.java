package com.speedtalk.oldprotol;

import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.protocol.TSCObject;

import java.util.List;

public interface ProtolAdapter {
    public List<TSCObject> adapt(Mess mess) throws AdaptExcepton;

    public List<Mess> adapt(TSCObject obj) throws AdaptExcepton;
}
