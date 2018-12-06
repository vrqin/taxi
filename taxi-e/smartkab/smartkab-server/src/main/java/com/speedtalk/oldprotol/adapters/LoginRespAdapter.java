package com.speedtalk.oldprotol.adapters;

import com.speedtalk.oldprotol.AdaptExcepton;
import com.speedtalk.oldprotol.ProtolAdapter;
import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.tscobjs.LoginResp;
import com.speedtalk.utils.LoadXmlConfig;

import java.util.ArrayList;
import java.util.List;

public class LoginRespAdapter implements ProtolAdapter {
    @Override
    public List<TSCObject> adapt(Mess mess) throws AdaptExcepton {
        if (null == mess)
            throw new AdaptExcepton("Mess is null!");
        ArrayList<TSCObject> list = new ArrayList<TSCObject>();
        LoginResp loginResp = new LoginResp();
        try {
            //			loginResp.setSrcMsID(mess.getSrcMsID());
            loginResp.setSrcMsID(LoadXmlConfig.getConfigHash().get("msid"));
            loginResp.setMessNo((short) mess.getSerialNo());
            loginResp.setResult((byte) ((com.speedtalk.oldprotol.mess.MessResp) mess).getResult());
            list.add(loginResp);
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
        com.speedtalk.oldprotol.mess.LoginResp loginResp = new com.speedtalk.oldprotol.mess.LoginResp();
        try {
            loginResp.setSrcMsID(obj.getSrcMsID());
            loginResp.setSerialNo(obj.getMessNo());
            loginResp.setResult(((LoginResp) obj).getResult());
            list.add(loginResp);
        } catch (Exception e) {
            throw new AdaptExcepton(e);
        }
        return list;
    }
}
