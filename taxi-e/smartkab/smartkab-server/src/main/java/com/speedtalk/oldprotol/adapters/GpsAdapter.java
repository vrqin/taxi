package com.speedtalk.oldprotol.adapters;

import com.poctalk.protocols.gps.Gps;
import com.speedtalk.oldprotol.AdaptExcepton;
import com.speedtalk.oldprotol.ProtolAdapter;
import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.oldprotol.mess.Position;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.tscobjs.GPS;
import com.speedtalk.utils.LoadXmlConfig;
import com.speedtalk.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class GpsAdapter implements ProtolAdapter {
    @Override
    public List<TSCObject> adapt(Mess mess) throws AdaptExcepton {
        if (null == mess)
            throw new AdaptExcepton("Mess is null!");
        ArrayList<TSCObject> list = new ArrayList<TSCObject>();
        GPS gps = new GPS();
        try {
            //			Gps oldGps = Gps.parseBkGpsToBytes(((MoGps)mess).getData());
            Gps oldGps = ((Position) mess).getGps();

            gps.setSrcMsID(LoadXmlConfig.getConfigHash().get("msid-prefix") + oldGps.getMsID());
            gps.setMessNo((short) mess.getSerialNo());
            gps.setLg(oldGps.getPosition().getLongitude());
            gps.setLt(oldGps.getPosition().getLatitude());
            gps.setSpeed(oldGps.getSpeed() * 1.852f);
            gps.setDirection((short) oldGps.getPosition().getDirection());
            gps.setTime(StringUtils.formatDate(oldGps.getPosition().getGpsDate().getTimeInMillis(), "yyyyMMddHHmmss"));
            list.add(gps);
        } catch (Exception e) {
            throw new AdaptExcepton(e);
        }

        return list;
    }

    @Override
    public List<Mess> adapt(TSCObject obj) throws AdaptExcepton {
        // TODO Auto-generated method stub
        return null;
    }
}
