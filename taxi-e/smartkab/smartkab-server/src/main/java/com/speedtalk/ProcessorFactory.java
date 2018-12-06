package com.speedtalk;

import com.speedtalk.oldprotol.MessComIdConstants;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.oldprotol.mess.QueryResp;
import com.speedtalk.oldprotol.processors.AbstractOldProcessor;
import com.speedtalk.oldprotol.processors.GrpsOfMsQueryRespProcessor;
import com.speedtalk.oldprotol.processors.MsOfGrpQueryRespProcessor;
import com.speedtalk.oldprotol.processors.OldOtherProcessor;
import com.speedtalk.processors.*;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.MessIdConstants;
import com.speedtalk.tsc.handler.AbstractProcessor;

public class ProcessorFactory {
    private final static ProcessorFactory instance = new ProcessorFactory();
    private LoginResp loginResp;
    private Hb hb;
    private HbResp hbResp;
    private Gps gps;
    private Notice notice;
    private Sms sms;
    private Other other;
    private GrpsOfMsQueryRespProcessor grpsOfMsQueryRespProcessor;
    private MsOfGrpQueryRespProcessor msOfGrpQueryRespProcessor;
    private OldOtherProcessor oldOtherProcessor;

    private ProcessorFactory() {
        loginResp = new LoginResp();
        hb = new Hb();
        hbResp = new HbResp();
        gps = new Gps();
        notice = new Notice();
        sms = new Sms();
        other = new Other();
        grpsOfMsQueryRespProcessor = new GrpsOfMsQueryRespProcessor();
        msOfGrpQueryRespProcessor = new MsOfGrpQueryRespProcessor();
        oldOtherProcessor = new OldOtherProcessor();
    }

    public static ProcessorFactory getInstance() {
        return instance;
    }

    public AbstractProcessor getProcessor(TSCObject object) {
        if (null == object)
            return other;
        if (MessIdConstants.LOGIN_RESP == object.getMessID())
            return loginResp;
        else if (MessIdConstants.HB == object.getMessID())
            return hb;
        else if (MessIdConstants.HB_RESP == object.getMessID())
            return hbResp;
        else if (MessIdConstants.GPS == object.getMessID())
            return gps;
        else if (MessIdConstants.NOTICE == object.getMessID())
            return notice;
        else if (MessIdConstants.SMS == object.getMessID())
            return sms;
        else
            return other;
    }

    public AbstractOldProcessor getProcessor(Mess object) {
        if (null == object)
            return oldOtherProcessor;
        if (MessComIdConstants.QUERY_RESP == object.getCommId()) {
            QueryResp queryResp = (QueryResp) object;
            if (OptionConstants.GRPS_OF_MS_QUERY == queryResp.getOption())
                return grpsOfMsQueryRespProcessor;
            else if (OptionConstants.MS_OF_GRP_QUERY == queryResp.getOption())
                return msOfGrpQueryRespProcessor;
            else
                return oldOtherProcessor;
        } else
            return oldOtherProcessor;
    }
}
