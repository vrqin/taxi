package com.speedtalk.oldprotol.processors;

import com.speedtalk.KabConstants;
import com.speedtalk.StartUp;
import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.oldprotol.mess.MsOfGrpQueryResp;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.session.IoSession;

public class MsOfGrpQueryRespProcessor extends AbstractOldProcessor {
    @Override
    public void process(IoSession arg0, TSCObject arg1) {
        // TODO Auto-generated method stub
    }

    public void process(IoSession arg0, Mess arg1) {
        try {
            MsOfGrpQueryResp resp = (MsOfGrpQueryResp) arg1;
            StartUp.LOG.debug(KabConstants.getOldLogPrefix() + " ms:" + resp.getMsCount() + "," + resp.getMsList()
                    .toString());
            //			for(MsInfo msInfo : resp.getMsList())
            //				KabTeam.getInstance().updateKab(new KabInfo(msInfo.getMsId(),
            //						(msInfo.getOnlineStatus() == 1 ? (byte)1 : (byte)0),(byte)0,0,0));
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
