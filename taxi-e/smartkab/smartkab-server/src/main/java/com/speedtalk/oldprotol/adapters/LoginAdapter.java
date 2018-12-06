package com.speedtalk.oldprotol.adapters;

import com.speedtalk.oldprotol.AdaptExcepton;
import com.speedtalk.oldprotol.ProtolAdapter;
import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.tscobjs.Login;

import java.util.ArrayList;
import java.util.List;

public class LoginAdapter implements ProtolAdapter {
    @Override
    public List<TSCObject> adapt(Mess mess) throws AdaptExcepton {
        if (null == mess)
            throw new AdaptExcepton("Mess is null!");
        ArrayList<TSCObject> list = new ArrayList<TSCObject>();
        Login login = new Login();
        try {
            login.setSrcMsID(mess.getSrcMsID());
            login.setMessNo((short) mess.getSerialNo());
            login.setPwd(((com.speedtalk.oldprotol.mess.Login) mess).getPwd());
            list.add(login);
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
        com.speedtalk.oldprotol.mess.Login login = new com.speedtalk.oldprotol.mess.Login();
        try {
            login.setSrcMsID(obj.getSrcMsID());
            login.setSerialNo(obj.getMessNo());
            login.setPwd(((Login) obj).getPwd());
            list.add(login);
        } catch (Exception e) {
            throw new AdaptExcepton(e);
        }
        return list;
    }
}
