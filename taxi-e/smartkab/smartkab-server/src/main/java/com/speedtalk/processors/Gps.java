package com.speedtalk.processors;

import com.speedtalk.KabConstants;
import com.speedtalk.StartUp;
import com.speedtalk.kabs.KabInfo;
import com.speedtalk.kabs.KabTeam;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.tsc.handler.AbstractProcessor;
import com.speedtalk.utils.ExcepPrinter;
import org.apache.mina.core.session.IoSession;

import java.text.SimpleDateFormat;

public class Gps extends AbstractProcessor {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    @Override
    public void process(IoSession arg0, TSCObject arg1) {
        try {
            com.speedtalk.protocol.tscobjs.GPS gps = (com.speedtalk.protocol.tscobjs.GPS) arg1;
            KabInfo kabInfo = KabTeam.getInstance().getKab(gps.getSrcMsID());
            if (null == kabInfo) {
                kabInfo = new KabInfo(gps.getSrcMsID(), KabTeam.ONLINE, KabTeam.UNCARRY, gps.getLg(), gps.getLt(), sdf.parse(gps
                        .getTime()).getTime());
                KabTeam.getInstance().addKab(kabInfo);
            } else {
                kabInfo.setLg(gps.getLg());
                kabInfo.setLt(gps.getLt());
            }
            StartUp.LOG.debug(KabConstants.getPhoenixLogPrefix() + gps.toString());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
