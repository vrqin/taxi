package com.speedtalk.oldprotol.adapters;

import com.speedtalk.oldprotol.AdaptExcepton;
import com.speedtalk.oldprotol.ProtolAdapter;
import com.speedtalk.oldprotol.mess.GpsHB;
import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.tscobjs.HB;

import java.util.ArrayList;
import java.util.List;

public class HBAdapter implements ProtolAdapter {
    @Override
    public List<TSCObject> adapt(Mess mess) throws AdaptExcepton {
        if (null == mess)
            throw new AdaptExcepton("Mess is null!");
        ArrayList<TSCObject> list = new ArrayList<TSCObject>();
        HB hb = new HB();
        try {
            hb.setSrcMsID(mess.getSrcMsID());
            hb.setMessNo((short) mess.getSerialNo());
            list.add(hb);
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
        //		EmptyMess hb = new EmptyMess();
        //		try
        //		{
        //			hb.setCommId(MessComIdConstants.HB);
        //			hb.setSrcMsID(obj.getSrcMsID());
        //			hb.setSerialNo(obj.getMessNo());
        //			list.add(hb);
        list.add(new GpsHB(obj.getSrcMsID()));
        //		}
        //		catch(Exception e)
        //		{
        //			throw new AdaptExcepton(e);
        //		}
        return list;
    }
}
