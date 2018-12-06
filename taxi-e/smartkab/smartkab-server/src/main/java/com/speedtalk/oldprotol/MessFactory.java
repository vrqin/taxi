package com.speedtalk.oldprotol;

import com.speedtalk.oldprotol.mess.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ConcurrentHashMap;

public class MessFactory {
    private static MessFactory instance;
    private ConcurrentHashMap<Integer, Object> messMap = new ConcurrentHashMap<Integer, Object>();
    private ConcurrentHashMap<Byte, Object> queryRespMap = new ConcurrentHashMap<Byte, Object>();

    private MessFactory() {
        messMap.put(MessComIdConstants.CONN, Login.class);
        messMap.put(MessComIdConstants.CONN_RESP, MessResp.class);
        messMap.put(MessComIdConstants.PTT, PTT.class);
        messMap.put(MessComIdConstants.PTT_RESP, MessResp.class);
        //		messMap.put(MessIdConstants.PTT_IN,);
        //		messMap.put(MessIdConstants.PTT_IN_RESP,);
        messMap.put(MessComIdConstants.HUP, PTT.class);
        messMap.put(MessComIdConstants.HUP_RESP, MessResp.class);
        //		messMap.put(MessIdConstants.HUPIN,);
        //		messMap.put(MessIdConstants.HUPIN_RESP,);
        messMap.put(MessComIdConstants.NOTIFY, Notify.class);
        messMap.put(MessComIdConstants.NOTIFY_RESP, MessResp.class);
        messMap.put(MessComIdConstants.QUERY, Query.class);
        messMap.put(MessComIdConstants.QUERY_RESP, QueryResp.class);
        messMap.put(MessComIdConstants.HB, EmptyMess.class);
        messMap.put(MessComIdConstants.HB_RESP, MessResp.class);
        messMap.put(MessComIdConstants.MO_GPS, MoGps.class);
        //		messMap.put(MessIdConstants.SMS,);
        //		messMap.put(MessIdConstants.SMS_RESP,);
        messMap.put(MessComIdConstants.SSMS, Sms.class);
        messMap.put(MessComIdConstants.SSMS_RESP, MessResp.class);
        messMap.put(MessComIdConstants.MO_VOICE, MediaMess.class);
        messMap.put(MessComIdConstants.MT_VOICE, MediaMess.class);
        messMap.put(MessComIdConstants.HUP_EGRP, PTT.class);
        messMap.put(MessComIdConstants.HUP_EGRP_RESP, MessResp.class);
        messMap.put(MessComIdConstants.DPTT, DPTT.class);
        messMap.put(MessComIdConstants.DPTT_RESP, MessResp.class);
        messMap.put(MessComIdConstants.PTT_ALL, PTT.class);
        messMap.put(MessComIdConstants.PTT_ALL_RESP, MessResp.class);
        messMap.put(MessComIdConstants.FOR_HUP, PTT.class);
        messMap.put(MessComIdConstants.FOR_HUP_RESP, MessResp.class);
        //		messMap.put(MessIdConstants.MS_HUP,);
        //		messMap.put(MessIdConstants.MS_HUP_RESP,);
        messMap.put(MessComIdConstants.VOICE, MediaMess.class);
        messMap.put(MessComIdConstants.RES_CALL, EmptyMess.class);

        queryRespMap.put(OptionConstants.MYSELF_QUERY, MyselfQueryResp.class);
        queryRespMap.put(OptionConstants.GRPS_OF_MS_QUERY, GrpsOfMsQueryResp.class);
        queryRespMap.put(OptionConstants.MS_STATUS_QUERY, MsStatusQueryResp.class);
        queryRespMap.put(OptionConstants.MS_OF_GRP_QUERY, MsOfGrpQueryResp.class);
    }

    public static MessFactory getInstance() {
        if (null == instance)
            instance = new MessFactory();
        return instance;
    }

    public Mess getMess(byte[] datas) throws Exception {
        //		StartUp.LOG.debug(StringUtils.bytesToHexStr(datas));
        ByteBuffer buffer = ByteBuffer.wrap(datas);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        //		buffer.position(buffer.position() + 4);	//java.lang.IllegalArgumentException
        buffer.getInt();
        return ((Class<Mess>) messMap.get(buffer.getInt())).newInstance();
    }

    public QueryResp getQueryResp(byte[] datas) throws Exception {
        ByteBuffer buffer = ByteBuffer.wrap(datas);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.position(buffer.position() + 14);
        return ((Class<QueryResp>) queryRespMap.get(buffer.get())).newInstance();
    }
}
