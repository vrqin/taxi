package com.speedtalk.oldprotol.adapters;

import com.speedtalk.oldprotol.AdaptExcepton;
import com.speedtalk.oldprotol.ProtolAdapter;
import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.oldprotol.mess.Sms;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.tscobjs.SMS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SmsAdapter implements ProtolAdapter {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd HH:mm:ss");

    @Override
    public List<TSCObject> adapt(Mess mess) throws AdaptExcepton {
        if (null == mess)
            return null;
        Calendar cal = Calendar.getInstance();
        ArrayList<TSCObject> list = new ArrayList<TSCObject>();
        SMS sms = null;
        Sms oldSms = (Sms) mess;
        try {
            for (String msId : oldSms.getMsList()) {
                sms = new SMS();
                sms.setSrcMsID(mess.getSrcMsID());
                sms.setDstMsID(msId);
                sms.setMessNo((short) mess.getSerialNo());
                //				sms.setMsName("");
                sms.setContent(oldSms.getContent());
                sms.setTime(sdf.format(cal.getTime()));
                list.add(sms);
            }
        } catch (Exception e) {
        }

        return list;
    }

    @Override
    public List<Mess> adapt(TSCObject obj) throws AdaptExcepton {
        if (null == obj)
            throw new AdaptExcepton("TSCObject is null!");
        ArrayList<Mess> list = new ArrayList<Mess>();

        try {
            SMS sms = (SMS) obj;
            com.speedtalk.oldprotol.mess.GpsSms gpsSms = new com.speedtalk.oldprotol.mess.GpsSms(sms.getDstMsID(), sms.getContent());

            list.add(gpsSms);
        } catch (Exception e) {
            throw new AdaptExcepton(e);
        }
        return list;
    }
}
