package com.speedtalk.oldprotol;

import com.speedtalk.oldprotol.adapters.*;
import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.MessIdConstants;

import java.util.concurrent.ConcurrentHashMap;

public class AdapterFactory {
    private static AdapterFactory instance;
    private ConcurrentHashMap<Integer, ProtolAdapter> messAdapterMap = new ConcurrentHashMap<Integer, ProtolAdapter>();
    private ConcurrentHashMap<Byte, ProtolAdapter> objAdapterMap = new ConcurrentHashMap<Byte, ProtolAdapter>();

    private AdapterFactory() {
        messAdapterMap.put(MessComIdConstants.CONN, new LoginAdapter());
        messAdapterMap.put(MessComIdConstants.CONN_RESP, new LoginRespAdapter());
        //		messAdapterMap.put(MessComIdConstants.PTT,PTT.class);
        //		messAdapterMap.put(MessComIdConstants.PTT_RESP,MessResp.class);
        ////		messAdapterMap.put(MessComIdConstants.PTT_IN,);
        ////		messAdapterMap.put(MessComIdConstants.PTT_IN_RESP,);
        //		messAdapterMap.put(MessComIdConstants.HUP,PTT.class);
        //		messAdapterMap.put(MessComIdConstants.HUP_RESP,MessResp.class);
        ////		messAdapterMap.put(MessComIdConstants.HUPIN,);
        ////		messAdapterMap.put(MessComIdConstants.HUPIN_RESP,);
        messAdapterMap.put(MessComIdConstants.NOTIFY, new NoticeAdapter());
        //		messAdapterMap.put(MessComIdConstants.NOTIFY_RESP,MessResp.class);
        //		messAdapterMap.put(MessComIdConstants.QUERY,Query.class);
        //		messAdapterMap.put(MessComIdConstants.QUERY_RESP,QueryResp.class);
        messAdapterMap.put(MessComIdConstants.HB, new HBAdapter());
        messAdapterMap.put(MessComIdConstants.HB_RESP, new HBRespAdapter());
        //		messAdapterMap.put(MessComIdConstants.MO_GPS,GpsAdapter.class);
        messAdapterMap.put(new Integer(OptionConstants.GPS), new GpsAdapter());
        ////		messAdapterMap.put(MessComIdConstants.SMS,);
        ////		messAdapterMap.put(MessComIdConstants.SMS_RESP,);
        //		messAdapterMap.put(MessComIdConstants.SSMS,Sms.class);
        //		messAdapterMap.put(MessComIdConstants.SSMS_RESP,MessResp.class);
        //		messAdapterMap.put(MessComIdConstants.MO_VOICE,MediaMess.class);
        //		messAdapterMap.put(MessComIdConstants.MT_VOICE,Voice.class);
        //		messAdapterMap.put(MessComIdConstants.HUP_EGRP,PTT.class);
        //		messAdapterMap.put(MessComIdConstants.HUP_EGRP_RESP,MessResp.class);
        //		messAdapterMap.put(MessComIdConstants.DPTT,DPTT.class);
        //		messAdapterMap.put(MessComIdConstants.DPTT_RESP,MessResp.class);
        //		messAdapterMap.put(MessComIdConstants.PTT_ALL,PTT.class);
        //		messAdapterMap.put(MessComIdConstants.PTT_ALL_RESP,MessResp.class);
        //		messAdapterMap.put(MessComIdConstants.FOR_HUP,PTT.class);
        //		messAdapterMap.put(MessComIdConstants.FOR_HUP_RESP,MessResp.class);
        ////		messAdapterMap.put(MessComIdConstants.MS_HUP,);
        ////		messAdapterMap.put(MessComIdConstants.MS_HUP_RESP,);
        //		messAdapterMap.put(MessComIdConstants.VOICE,Voice.class);
        //		messAdapterMap.put(MessComIdConstants.RES_CALL,EmptyMess.class);

        objAdapterMap.put(MessIdConstants.LOGIN, new LoginAdapter());
        objAdapterMap.put(MessIdConstants.LOGIN_RESP, new LoginRespAdapter());
        objAdapterMap.put(MessIdConstants.HB, new HBAdapter());
        objAdapterMap.put(MessIdConstants.HB_RESP, new HBRespAdapter());
        objAdapterMap.put(MessIdConstants.SMS, new SmsAdapter());
    }

    public static AdapterFactory getInstance() {
        if (null == instance)
            instance = new AdapterFactory();
        return instance;
    }

    public ProtolAdapter getAdapter(Mess mess) throws AdaptExcepton, UnsupportedAdaptException {
        if (null == mess)
            throw new AdaptExcepton("Mess is null!");
        if (null == messAdapterMap.get(mess.getCommId()))
            throw new UnsupportedAdaptException();
        return messAdapterMap.get(mess.getCommId());
    }

    public ProtolAdapter getAdapter(TSCObject obj) throws AdaptExcepton, UnsupportedAdaptException {
        if (null == obj)
            throw new AdaptExcepton("TSCObject is null!");
        if (null == objAdapterMap.get(obj.getMessID()))
            throw new UnsupportedAdaptException();
        return objAdapterMap.get(obj.getMessID());
    }
}
