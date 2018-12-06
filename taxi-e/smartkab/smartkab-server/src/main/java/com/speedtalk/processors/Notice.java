package com.speedtalk.processors;

import com.speedtalk.KabConstants;
import com.speedtalk.StartUp;
import com.speedtalk.kabs.KabInfo;
import com.speedtalk.kabs.KabTeam;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.TypeConstants;
import com.speedtalk.tsc.handler.AbstractProcessor;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.session.IoSession;

public class Notice extends AbstractProcessor {
    @Override
    public void process(IoSession arg0, TSCObject arg1) {
        try {
            com.speedtalk.protocol.tscobjs.Notice notice = (com.speedtalk.protocol.tscobjs.Notice) arg1;
            StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + notice.toString());
            if (notice.getType() == TypeConstants.OFFLINE_NOTICE || notice.getType() == TypeConstants.ONLINE_NOTICE) {
                KabInfo kabInfo = KabTeam.getInstance().getKab(notice.getMsID());
                try {
                    if (notice.getType() == TypeConstants.ONLINE_NOTICE)
                        kabInfo.setOnline(KabTeam.ONLINE);
                    else
                        kabInfo.setOnline(KabTeam.OFFLINE);
                } catch (Exception e) {
                }
                StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + notice.getMsID() + "--" + notice.getType());
            }
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
