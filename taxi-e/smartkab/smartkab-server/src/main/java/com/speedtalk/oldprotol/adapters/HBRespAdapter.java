package com.speedtalk.oldprotol.adapters;

import com.speedtalk.oldprotol.AdaptExcepton;
import com.speedtalk.oldprotol.MessComIdConstants;
import com.speedtalk.oldprotol.ProtolAdapter;
import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.oldprotol.mess.MessResp;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.tscobjs.HBResp;
import com.speedtalk.utils.LoadXmlConfig;

import java.util.ArrayList;
import java.util.List;

public class HBRespAdapter implements ProtolAdapter {
    @Override
    public List<TSCObject> adapt(Mess mess) throws AdaptExcepton {
        if (null == mess)
            throw new AdaptExcepton("Mess is null!");
        ArrayList<TSCObject> list = new ArrayList<TSCObject>();
        HBResp hbResp = new HBResp();
        try {
            //			hbResp.setSrcMsID(mess.getSrcMsID());
            hbResp.setSrcMsID(LoadXmlConfig.getConfigHash().get("msid"));
            hbResp.setMessNo((short) mess.getSerialNo());
            hbResp.setHbInterval((byte) 120);
            list.add(hbResp);
        } catch (Exception e) {
            throw new AdaptExcepton(e);
        }

        return list;
    }

    @Override
    public List<Mess> adapt(TSCObject obj) throws AdaptExcepton {
        if (null == obj)
            throw new AdaptExcepton("TSCObject is null!");
        ArrayList<Mess> list = new ArrayList<Mess>();
        MessResp hbResp = new MessResp();
        try {
            hbResp.setCommId(MessComIdConstants.HB_RESP);
            hbResp.setSrcMsID(obj.getSrcMsID());
            hbResp.setSerialNo(obj.getMessNo());
            hbResp.setResult((short) 0);
            list.add(hbResp);
        } catch (Exception e) {
            throw new AdaptExcepton(e);
        }
        return list;
    }
}
