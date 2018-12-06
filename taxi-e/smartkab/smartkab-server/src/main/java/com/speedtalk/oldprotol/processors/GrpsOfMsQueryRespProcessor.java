package com.speedtalk.oldprotol.processors;

import com.speedtalk.ClientInfo;
import com.speedtalk.KabConstants;
import com.speedtalk.StartUp;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.oldprotol.mess.GrpsOfMsQueryResp;
import com.speedtalk.oldprotol.mess.GrpsOfMsQueryResp.GrpInfo;
import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.oldprotol.mess.Query;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.session.IoSession;

public class GrpsOfMsQueryRespProcessor extends AbstractOldProcessor {
    @Override
    public void process(IoSession arg0, TSCObject arg1) {
        // TODO Auto-gen1rated method stub
    }

    public void process(IoSession arg0, Mess arg1) {
        try {
            GrpsOfMsQueryResp resp = (GrpsOfMsQueryResp) arg1;
            StartUp.LOG.debug(KabConstants.getOldLogPrefix() + "all grp:" + resp.getGrpCount() + "," + resp.getGrpList()
                    .toString());
            Query query = new Query(ClientInfo.getInstance().getMsId(), OptionConstants.MS_OF_GRP_QUERY);
            for (GrpInfo grpInfo : resp.getGrpList()) {
                query.setParam(grpInfo.getGrpId());
                arg0.write(query);

                Thread.sleep(3000);
            }
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
